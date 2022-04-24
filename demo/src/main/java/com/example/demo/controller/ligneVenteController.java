package com.example.demo.controller;

import com.example.demo.service.ApproService;
import com.example.demo.service.LigneVenteService;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ligneVente")

public class ligneVenteController {
    @Autowired
    private LigneVenteService ligneVenteService;
    @Autowired
    private ProduitService produitService;


}
