package com.example.demo.service;

import com.example.demo.model.LigneVente;
import com.example.demo.model.repository.LigneVenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneVenteService {
    @Autowired
    private final LigneVenteRepository ligneVenteRepo;

    public LigneVenteService(LigneVenteRepository ligneVenteRepo){
        this.ligneVenteRepo = ligneVenteRepo;
    }

    public LigneVente AjouterLigneVente(LigneVente ligneVente){
        return ligneVenteRepo.save(ligneVente);
    }

    public List<LigneVente> AfficherLigneVente() {
        return ligneVenteRepo.findAll();
    }

    public LigneVente UpdateLigneVente(LigneVente ligneVente){
        return ligneVenteRepo.save(ligneVente);
    }

    public LigneVente FindLigneVenteById(Integer idLigneVente){

        Optional<LigneVente> optional = ligneVenteRepo.findById(idLigneVente);
        LigneVente ligneVente = null;
        if(optional.isPresent())
        {
            ligneVente = optional.get();
        }else
        {
            throw new RuntimeException("id introuvable");
        }
        return  ligneVente;

    }
    public void save(LigneVente ligneVente){
         ligneVenteRepo.save(ligneVente);
    }
    public void DeleteLigneVente(int idLigneVente){
        ligneVenteRepo.deleteById(idLigneVente);
    }
    public double calcMontant(int qte,double PU){
        return qte*PU;
    }
}
