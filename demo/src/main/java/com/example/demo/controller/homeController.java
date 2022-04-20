package com.example.demo.controller;

import com.example.demo.model.Utilisateur;
import com.security.configurations.MyUserDetails;
import com.security.configurations.MyUserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
@Controller
public class homeController {
    @GetMapping("/")
    public String afficherHello(){
        return "Hello";
    }
    @GetMapping("/login")
    public String login(Utilisateur util){
        util.setNom("user");
        util.setPassword("1234");
        MyUserDetailsService userDetailsService = new MyUserDetailsService();
        userDetailsService.loadUserByUsername(util.getNom());
        if(util.getRole()=="user")
            return "redirect:/home/user";
        else if(util.getRole()=="admin")
            return "redirect:/home/admin";
        return "redirect:/home/user";
    }
    @GetMapping("/user")
    public String user(){
        return "userPage";
    }
    @GetMapping("/admin")
    public String admin(){
        return "redirect:/Produits/showProduit";
    }
}
