package co.id.mii.serverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.id.mii.serverside.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
