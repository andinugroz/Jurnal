package co.id.mii.serverside.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.id.mii.serverside.models.Jurnal;
import co.id.mii.serverside.services.JurnalService;

@RestController
@RequestMapping("/jurnal")
public class JurnalController {
    private JurnalService jurnalService;

    @Autowired
    public JurnalController(JurnalService jurnalService) {
        this.jurnalService = jurnalService;
    }

    @GetMapping
    public List<Jurnal> getAll() {
        return jurnalService.getAll();
    }

    @GetMapping("/{id}")
    public Jurnal getById(@PathVariable Long id) {
        return jurnalService.getById(id);
    }

    @PostMapping
    public Jurnal create(@RequestBody Jurnal jurnal) {
        return jurnalService.create(jurnal);
    }

    @PutMapping("/{id}")
    public Jurnal update(@PathVariable Long id, @RequestBody Jurnal jurnal) {
        return jurnalService.update(id, jurnal);
    }

    @DeleteMapping("/{id}")
    public Jurnal delete(@PathVariable Long id) {
        return jurnalService.delete(id);
    }

    @GetMapping("/status")
    public List<Jurnal> getAllstatus() {
        return jurnalService.getAllstatus();
    }

    @GetMapping("/addjurnal")
    public List<Jurnal> getAlladdjurnal() {
        return jurnalService.getAlladdjurnal();
    }

}
