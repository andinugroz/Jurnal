package com.mii.clientapp.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mii.clientapp.model.Jurnal;
import com.mii.clientapp.service.JurnalService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/jurnal")
public class RestJurnalController {
    private JurnalService jurnalService;

    @GetMapping
    public List<Jurnal> getAll() {
        return jurnalService.getAll();
    }

    @GetMapping("/status")
    public List<Jurnal> getAllstatus() {
        return jurnalService.getAllstatus();
    }

    @GetMapping("/addjurnal")
    public List<Jurnal> getAlladdjurnal() {
        return jurnalService.getAlladdjurnal();
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
    public Jurnal delete(@PathVariable Long id, Jurnal jurnal) {
        return jurnalService.delete(id);
    }
}
