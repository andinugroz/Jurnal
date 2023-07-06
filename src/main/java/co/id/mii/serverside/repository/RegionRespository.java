package co.id.mii.serverside.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.id.mii.serverside.models.Region;

@Repository
public interface RegionRespository extends JpaRepository<Region, Long> {
    Boolean existsByName(String name);

    // // JPQL for Entity
    // @Query("SELECT r FROM Regon r ")
    // List<Region> findAllJQLEntity();

    // // JPQL for Native Query
    // @Query(value = "SELECT * FROM region WHERE id = ?1", nativeQuery = true)
    // List<Region> findByRegionIdNative(Long id);
}
