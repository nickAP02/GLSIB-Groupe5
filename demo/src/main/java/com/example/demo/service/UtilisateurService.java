package com.example.demo.service;

import com.example.demo.model.Utilisateur;
import com.example.demo.model.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    public Utilisateur getUserByUsername(String username)
    {
        return utilisateurRepository.getUserByUsername(username);
    }
    public Utilisateur findByUsername(String username)
    {
        return utilisateurRepository.getUserByUsername(username);
    }
    public Utilisateur getUserById(int id)
    {
      return utilisateurRepository.getUserById(id);
    }
}
