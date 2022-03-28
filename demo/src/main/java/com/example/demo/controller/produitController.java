package com.example.demo.controller;

import com.example.demo.model.Produit;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/produit")
public class produitController {
    @Autowired
    private ProduitService produitService;
    private CategoryService categoryService;
    @GetMapping("/afficher")
    public String displayProduit(Model model){
        model.addAttribute("produits",produitService.showProduits());
        return "Produits/showProduit";
    }
    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("Listcategory",categoryService.showAllCategory());
        return "Produits/produit";
    }
    @PostMapping("/save")
    public String save(Produit produit){
        produit.setDateCreation(LocalDate.now());
        produit.setQteStock(0);
        produitService.saveProduit(produit);
        return "redirect:/produit/afficher";
    }
   @GetMapping("/edit/{id}")
   public String edit(@PathVariable("id") int id, Model model){
       model.addAttribute("produitId",produitService.showOneProduit(id));
       return "Produits/modification";
   }
    @PostMapping("/edit")
    public String edit(@ModelAttribute("produit") Produit produit)
    {
        produitService.saveProduit(produit);
        return "redirect:/produit/afficher";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model){
        model.addAttribute("produitId",produitService.showOneProduit(id));
        return "Produits/suppression";
    }
   /* @PostMapping("/delete")
    {

    }*/
}
