package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/vente")
public class venteController {
    @Autowired
    LigneVenteService ligneVente;
    @Autowired
    VenteService venteService;
    @Autowired
    ClientService clientService;
    @Autowired
    ProduitService produitService;
    @Autowired
    LigneVenteService ligneVenteService;
    @GetMapping("/All")
    public String GetAllVente() {
        //List<Vente> Vente = venteService.showAllVentes();
        return "Vente/showVente";
    }
    @GetMapping("/save")
    public String save(LigneVente lignes,@RequestParam("qte")int qte,@ModelAttribute("id")int id,@ModelAttribute("prix")float prix, Vente vente,Model model){
        //List<Vente> Vente = venteService.showAllVentes();
        model.addAttribute("produits",produitService.showProduits());
        model.addAttribute("ventes",ligneVenteService.AfficherLigneVente());
        lignes.setQuantite(qte);
        lignes.setProduit_id(id);
        lignes.setPrixUnitaire();
        ventes.setLigne(vente);
        venteService.save(ventes);
        ligneVenteService.save(vente);
        vente.setQuantite(qte);
        double pu = produit.getPrix();
        model.addAttribute("montant",ligneVenteService.calcMontant(qte,pu));
        vente.setPrixUnitaire(produit.getPrix());
        return "User/userPage";
    }
    @GetMapping("/Find/{id}")
    public String TrouverVentebyId(@PathVariable("id") int id){
        Vente FindVente = venteService.showProduitVendu(id);
        return "Vente/modification";
    }

    @PutMapping("/Update")
    public String UpdateVente(@RequestBody Vente vente){
        //Vente updateVente = venteService.save(vente);
        return "Vente/modification";
    }

    @DeleteMapping("/Delete/{id}")
    public String DeleteVente(@PathVariable("id_Vente") Integer idVente){
        venteService.delete(idVente);
        return "Vente/suppression";
    }
}
