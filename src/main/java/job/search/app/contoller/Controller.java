package job.search.app.contoller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import job.search.app.dto.*;
import job.search.app.service.ApplicationService;
import job.search.app.validation.ApikeyValidation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.net.MalformedURLException;

@Tag(name = "Job search app controller")
@RestController
@Validated
@RequestMapping("/api/job-search-app")
public class Controller {

    private final ApplicationService service;

    public Controller(ApplicationService service) {
        this.service = service;
    }

    @Operation(summary = "Save new client to database",
            responses = {@ApiResponse(responseCode = "201",
                    description = "Client saved successfully, responded with an API key"),
                    @ApiResponse(responseCode = "401",
                            description = "Too long name, invalid email format or email already exists")})
    @PostMapping("/client")
    public ResponseEntity<ApikeyDto> saveClient(@Valid @RequestBody ClientCreateCommand command) {
        return new ResponseEntity<>(service.saveClient(command), HttpStatus.CREATED);
    }

    @Operation(summary = "Save new position to database",
            responses = {@ApiResponse(responseCode = "201",
                    description = "Position saved successfully, responded with its URL"),
                    @ApiResponse(responseCode = "401",
                            description = "Invalid API key or name/location length exceeded limit")})
    @PostMapping("/position")
    public ResponseEntity<PositionUrlDto> savePosition(@Valid @RequestBody PositionCreateCommand command)
            throws MalformedURLException {
        return new ResponseEntity<>(service.savePosition(command), HttpStatus.CREATED);
    }

    @Operation(summary = "Retrieve position from database",
            responses = {@ApiResponse(responseCode = "200",
                    description = "Position viewed successfully"),
                    @ApiResponse(responseCode = "401",
                            description = "Position doesn't exist")})
    @GetMapping("/position/{id}")
    public ResponseEntity<PositionDto> findPosition(@PathVariable("id") Long positionId) {
        return new ResponseEntity<>(service.findPosition(positionId), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve positions from database by given conditions",
            responses = {@ApiResponse(responseCode = "200",
                    description = "Position(s) viewed successfully, responded with their URLs"),
                    @ApiResponse(responseCode = "401",
                            description = "Invalid API key or name/location length exceeded limit")})
    @GetMapping("/position/search")
    public ResponseEntity<PositionUrlListDto> searchPositions(@RequestParam(name = "keyword")
                                                              @Size(max = 50) String keyword,
                                                              @RequestParam(name = "location")
                                                              @Size(max = 50) String location,
                                                              @RequestHeader(name = "X-API-key")
                                                              @ApikeyValidation String apikey)
            throws MalformedURLException {
        return new ResponseEntity<>(service.searchPositions(keyword, location), HttpStatus.OK);
    }
}
