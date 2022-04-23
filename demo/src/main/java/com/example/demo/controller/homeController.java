package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.model.Utilisateur;
import com.example.demo.service.UtilisateurService;
import com.security.configurations.MyUserDetails;
import com.security.configurations.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@RequestMapping("/home")
@Controller
public class homeController {
    @Autowired
    UtilisateurService utilisateurService;
    @GetMapping("/")
    public String login(){
        return "Auth/login";
    }
    @PostMapping("/login")
    public String registered(Authentication auth){
        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
            return "redirect:/home/admin";
        }
        else if(auth.getAuthorities().contains(new SimpleGrantedAuthority("USER"))) {
            return "redirect:/home/user";
        }
        return "Auth/userPage";
    }
    @GetMapping("/user")
    public String user(){
        return "Auth/userPage";
    }
    @GetMapping("/admin")
    public String admin(){
        return "Produits/showProduit";
    }
}
