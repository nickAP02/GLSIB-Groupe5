package com.example.demo.service;

import com.example.demo.model.Vente;
import com.example.demo.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VenteService {
    private final VenteRepository venteRepository;

    @Autowired
    public VenteService(VenteRepository venteRepository) {
        this.venteRepository = venteRepository;
    }
    public void saveVente(Vente vente)
    {
        venteRepository.save(vente);
    }

    public Vente showOneVente(int codeVente)
    {
        Optional<Vente> optional = venteRepository.findById(codeVente);
        Vente vente = null;
        if(optional.isPresent()){
            vente = optional.get();
        }
        else {
            throw new RuntimeException("------");
        }
        return vente;
    }

    public void deleteVente(int codeVente)
    {
        if(showOneVente(codeVente)!=null)
            venteRepository.deleteById(codeVente);
    }
}
