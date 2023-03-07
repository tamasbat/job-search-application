package job.search.app.service;

import job.search.app.domain.Client;
import job.search.app.domain.Position;
import job.search.app.dto.*;
import job.search.app.exceptionhandling.PositionNotFoundException;
import job.search.app.repository.ClientRepository;
import job.search.app.repository.PositionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ApplicationService {

    private final ClientRepository clientRepository;
    private final PositionRepository positionRepository;
    private final ModelMapper modelMapper;
    private final HttpServletRequest request;

    public ApplicationService(ClientRepository clientRepository,
                              PositionRepository positionRepository,
                              ModelMapper modelMapper,
                              HttpServletRequest request) {
        this.clientRepository = clientRepository;
        this.positionRepository = positionRepository;
        this.modelMapper = modelMapper;
        this.request = request;
    }

    public ApikeyDto saveClient(ClientCreateCommand command) {
        Client client = modelMapper.map(command, Client.class)
                .setId(optionalIdCheck(clientRepository.findLatestId()))
                .setApikey(UUID.randomUUID().toString());
        return new ApikeyDto().setApikey(clientRepository.save(client).getApikey());
    }

    public PositionUrlDto savePosition(PositionCreateCommand command) throws MalformedURLException {
        Long id = optionalIdCheck(positionRepository.findLatestId());
        positionRepository.save(modelMapper.map(command, Position.class).setId(id));
        String baseUrl = request.getRequestURL().toString();
        return new PositionUrlDto().setUrl(new URL(baseUrl + "/" + id));
    }

    public boolean validateApikey(String apikey) {
        return clientRepository.findByApikey(apikey).isPresent();
    }

    public boolean validateUniqueEmail(String email) {
        return clientRepository.findByEmail(email).isEmpty();
    }

    public PositionUrlListDto searchPositions(String keyword, String location) throws MalformedURLException {
        String baseUrl = request.getRequestURL().toString().replace("/search", "");
        List<URL> urlList = new ArrayList<>();
        for (Position position : positionRepository.findByNameAndLocation(keyword, location)) {
            urlList.add(new URL(baseUrl + "/" + position.getId()));
        }
        return new PositionUrlListDto().setUrlList(urlList);
    }

    public PositionDto findPosition(Long positionId) {
        return modelMapper.map(findPositionById(positionId), PositionDto.class);
    }

    private Position findPositionById(Long id) {
        Optional<Position> optionalPosition = positionRepository.findById(id);
        if (optionalPosition.isPresent()) return optionalPosition.get();
        else throw new PositionNotFoundException();
    }

    private Long optionalIdCheck(Optional<Long> optional) {
        return optional.isPresent() ? optional.get() + 1 : 1;
    }
}