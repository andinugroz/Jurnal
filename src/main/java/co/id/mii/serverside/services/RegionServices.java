package co.id.mii.serverside.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.id.mii.serverside.models.Region;
import co.id.mii.serverside.repository.RegionRespository;

@Service
public class RegionServices {

    private RegionRespository regionRepository;

    @Autowired
    private RegionServices(RegionRespository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    public Region getById(long id) {
        if (!regionRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Region Not Found!");
        }
        return regionRepository.findById(id).get();
    }

    public Region create(Region region) {
        if (region.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Region already exist!");
        }
        return regionRepository.save(region);
    }

    public Region update(long id, Region region) {
        getById(id);
        region.setId(id);
        return regionRepository.save(region);
    }

    public Region delete(long id) {
        Region region = getById(id);
        regionRepository.delete(region);
        return region;
    }

}
