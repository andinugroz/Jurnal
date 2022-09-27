package co.id.mii.serverside.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.id.mii.serverside.models.Country;
import co.id.mii.serverside.repository.CountryRepository;

@Service
public class CountryServices {

    private CountryRepository countryRepository;

    @Autowired
    public CountryServices(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    public Country getById(long id) {
        if (!countryRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Region Not Found!");
        }
        return countryRepository.findById(id).get();
    }

    public Country create(Country country) {
        if (country.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Region already exist!");
        }
        return countryRepository.save(country);
    }

    public Country update(long id, Country country) {
        getById(id);
        country.setId(id);
        return countryRepository.save(country);
    }

    public Country delete(long id) {
        Country country = getById(id);
        countryRepository.delete(country);
        return country;
    }
}