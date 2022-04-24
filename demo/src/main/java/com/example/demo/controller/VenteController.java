package com.example.demo.controller;


import com.example.demo.model.Vente;
import com.example.demo.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/vente")
public class VenteController {
    @Autowired
    private VenteService venteService;

    @PostMapping("/save")
    public String save(Vente vente){
        vente.setDateVente(LocalDate.now());
        venteService.saveVente(vente);
        return "redirect:/vente/afficher";
    }

    @GetMapping("/delete/{codeVente}")
    public String delete(@PathVariable("codeVente") int codeVente, Model model){
        model.addAttribute("VenteCode",venteService.showOneVente(codeVente));
        return "Vente/suppression";
    }
}
