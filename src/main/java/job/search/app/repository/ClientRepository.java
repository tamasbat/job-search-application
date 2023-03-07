package job.search.app.repository;

import job.search.app.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByApikey(String apikey);

    Optional<Client> findByEmail(String email);

    @Query("SELECT MAX(c.id) FROM Client c")
    Optional<Long> findLatestId();
}
