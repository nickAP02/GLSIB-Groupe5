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

@Controller
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
    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("appro",approService.showAllAppro());
        return "Appro/produit";
    }
    @PostMapping("/save")
    public String save(Approvisionnement appro){
        approService.save(appro);
        return "redirect:/produit/afficher";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        System.out.println("id="+produitService.showOneProduit(id));
        model.addAttribute("produitId",produitService.showOneProduit(id));
        return "Appro/appro";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute("produit") Approvisionnement appro)
    {
        approService.save(appro);
        return "redirect:/produit/afficher";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model){
        model.addAttribute("produitId",produitService.showOneProduit(id));
        return "Appro/suppression";
    }
}
