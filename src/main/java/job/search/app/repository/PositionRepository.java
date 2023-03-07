package job.search.app.repository;

import job.search.app.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PositionRepository extends JpaRepository<Position, Long> {
    @Query("SELECT p FROM Position p " +
            "WHERE LOWER(p.name) LIKE CONCAT('%', LOWER(:keyword), '%') " +
            "AND LOWER(p.location) = LOWER(:location)")
    List<Position> findByNameAndLocation(@Param("keyword") String keyword, @Param("location") String location);

    @Query("SELECT MAX(p.id) FROM Position p")
    Optional<Long> findLatestId();
}
