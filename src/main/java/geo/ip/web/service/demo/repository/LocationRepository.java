package geo.ip.web.service.demo.repository;

import geo.ip.web.service.demo.model.Location;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query(value = "select l from Location l where l.ipFrom <= ?1 and l.ipTo >= ?1")
    Optional<Location> findLocationByIp(int ip);
}
