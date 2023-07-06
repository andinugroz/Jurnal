package co.id.mii.serverside.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.id.mii.serverside.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Boolean existsByName(String name);

    Optional<Country> findByName(String name);

    // JPQL for Entity
    @Query("SELECT c FROM Country c WHERE c.region.id = ?1")
    List<Country> findByRegionId(Long id);

    // JPQL for Native Query
    @Query(value = "SELECT * FROM country WHERE region_id = ?1", nativeQuery = true)
    List<Country> findByRegionIdNative(Long id);
}
