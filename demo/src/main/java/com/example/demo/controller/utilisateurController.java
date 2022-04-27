package com.example.demo.controller;

import com.example.demo.model.Produit;
import com.example.demo.model.Utilisateur;
import com.example.demo.service.MyUserDetailsService;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class utilisateurController {
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private ProduitService produitService;
    @GetMapping("/user")
    public String userProfile(){
        return "User/userPage";
    }
    @GetMapping("/admin")
    public String adminProfile(Model model){
        model.addAttribute("produits",produitService.showProduits());
        return "Admin/adminPage";
    }
}
