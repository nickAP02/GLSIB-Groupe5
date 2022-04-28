package com.example.demo.service;

import com.example.demo.model.Approvisionnement;
import com.example.demo.model.Vente;
import com.example.demo.model.repository.ApproRepository;
import com.example.demo.model.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenteService {
    @Autowired
    VenteRepository venteRepository;
    public void save(List<Vente> vente){
        venteRepository.saveAll(vente);
    }

    public List<Vente> showAllVentes(){
        return venteRepository.findAll();
    }

    public Vente showProduitVendu(int id){
        return venteRepository.findById(id).get();
    }
    public void delete(int id)
    {
        if(showProduitVendu(id)!=null)
            venteRepository.deleteById(id);
    }
}
