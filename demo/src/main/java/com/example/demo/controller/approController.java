package com.example.demo.controller;

import com.example.demo.model.Approvisionnement;
import com.example.demo.model.Produit;
import com.example.demo.model.repository.UtilisateurRepository;
import com.example.demo.service.ApproService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProduitService;
import com.example.demo.service.UtilisateurService;
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
    @Autowired
    UtilisateurService utilisateurService;
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
        appro.setDateAppro(LocalDate.now());
        approService.save(appro);
        produitService.updateQteStock(appro.getProduit_id(),appro.getQuantite());
        return "redirect:/appro/afficher";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model){
        model.addAttribute("produitId",approService.showOneProductAppro(id));
        return "Appro/suppression";
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute("produitId") int id){
        approService.delete(id);
        return "redirect:/appro/afficher";
    }
}
