package com.example.demo.service;

import com.example.demo.model.Approvisionnement;
import com.example.demo.model.Category;
import com.example.demo.model.repository.ApproRepository;
import com.example.demo.model.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApproService {
    @Autowired
    ApproRepository approRepository;
    ProduitRepository produitRepository;
    public void save(Approvisionnement appro){
        approRepository.save(appro);
    }

    public List<Approvisionnement> showAllAppro(){
        return approRepository.findAll();
    }

    public Approvisionnement showOneProductAppro(int id){
        return approRepository.findById(id).get();
    }
    public void delete(int id)
    {
        if(showOneProductAppro(id)!=null)
            approRepository.deleteById(id);
    }

}
