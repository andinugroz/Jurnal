package co.id.mii.serverside.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.id.mii.serverside.models.Country;
import co.id.mii.serverside.services.CountryServices;

@RestController
@RequestMapping("/country")
public class CountryController {

    private CountryServices countryServices;

    @Autowired
    public CountryController(CountryServices countryServices) {
        this.countryServices = countryServices;
    }

    @GetMapping
    public List<Country> getAll() {
        return countryServices.getAll();
    }

    @GetMapping("/regionId/{id}")
    public ResponseEntity<List<Country>> findByRegionId(@PathVariable Long id) {
        return new ResponseEntity(countryServices.findByRegionId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Country getById(@PathVariable Long id) {
        return countryServices.getById(id);
    }

    @PostMapping
    public Country create(@RequestBody Country country) {
        return countryServices.create(country);
    }

    @PutMapping("/{id}")
    public Country update(@PathVariable Long id, @RequestBody Country country) {
        return countryServices.update(id, country);
    }

    @DeleteMapping("/{id}")
    public Country delete(@PathVariable Long id) {
        return countryServices.delete(id);
    }

}
