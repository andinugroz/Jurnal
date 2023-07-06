package co.id.mii.serverside.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.id.mii.serverside.models.Jurnal;
import co.id.mii.serverside.repository.JurnalRepository;

@Service
public class JurnalService {
    private JurnalRepository jurnalRepository;

    @Autowired
    public JurnalService(JurnalRepository jurnalRepository) {
        this.jurnalRepository = jurnalRepository;
    }

    public List<Jurnal> getAll() {
        return jurnalRepository.findAll();
    }

    public Jurnal getById(long id) {
        if (!jurnalRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jurnal Not Found!");
        }
        return jurnalRepository.findById(id).get();
    }

    public Jurnal create(Jurnal jurnal) {
        if (jurnal.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Jurnal already exist");
        }
        return jurnalRepository.save(jurnal);
    }

    public Jurnal update(long id, Jurnal jurnal) {
        jurnal.setId(id);
        return jurnalRepository.save(jurnal);
    }

    public Jurnal delete(long id) {
        Jurnal jurnal = getById(id);
        jurnalRepository.delete(jurnal);
        return jurnal;
    }

    public List<Jurnal> getAllstatus() {
        return jurnalRepository.findAllstatusNative("Acc");
    }

    public List<Jurnal> getAlladdjurnal() {
        return jurnalRepository.findAlladdjurnalNative();
    }
}
