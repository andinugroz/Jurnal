package com.mii.clientapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mii.clientapp.model.Jurnal;
import com.mii.clientapp.service.JurnalService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/jurnal")
public class JurnalController {
    private JurnalService jurnalService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("jurnals", jurnalService.getAll());
        return "jurnal/index";
    }

    @GetMapping("/details/{id}")
    public String getId(@PathVariable Long id, Model model) {
        model.addAttribute("jurnals", jurnalService.getById(id));
        return "jurnal/details";
    }

    @GetMapping("/status")
    public String approve(Model model) {
        model.addAttribute("jurnalsapprove", jurnalService.getAllstatus());
        return "jurnalapprove/jurnalapprove";
    }

    @GetMapping("/addjurnal")
    public String addjurnal(Model model) {
        model.addAttribute("jurnalsapprove", jurnalService.getAlladdjurnal());
        return "jurnal/addjurnal-user";
    }

    @GetMapping("/create")
    public String create(Jurnal jurnal) {
        return "jurnal/create_jurnal";
    }

    @PostMapping
    public String created(Jurnal jurnal) {
        jurnalService.create(jurnal);
        return "redirect:/jurnal";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("jurnal", jurnalService.getById(id));
        return "jurnal/update_form";
    }

    @PutMapping("/{id}")
    public String updated(@PathVariable Long id, Jurnal jurnal) {
        jurnalService.update(id, jurnal);
        return "redirect:/jurnal";
    }

    @DeleteMapping("/{id}")
    public String deleted(@PathVariable Long id) {
        jurnalService.delete(id);
        return "redirect:/jurnal";
    }
}
