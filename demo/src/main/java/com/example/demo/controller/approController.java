package com.example.demo.controller;

import com.example.demo.model.Approvisionnement;
import com.example.demo.model.Produit;
import com.example.demo.service.ApproService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/appro")
public class approController {
    @Autowired
    private ApproService approService;
    @Autowired
    private ProduitService produitService;
    @GetMapping("/afficher")
    public String displayAppro(Model model){
        model.addAttribute("appro",approService.showAllAppro());
        return "Appro/showAppro";
    }
    @GetMapping("/form/{id}")
    public String form(@PathVariable("id") int id,Model model){
        model.addAttribute("produit",produitService.showOneProduit(id));
        return "Appro/appro";
    }
    @PostMapping("/save")
    public String save(Approvisionnement appro){
        approService.save(appro);
        produitService.updateQteStock(appro.getProduit_id(),appro.getQuantite());
        return "redirect:/produit/afficher";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model){
        model.addAttribute("produitId",produitService.showOneProduit(id));
        return "Appro/suppression";
    }
}
