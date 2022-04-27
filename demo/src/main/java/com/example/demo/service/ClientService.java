package com.example.demo.service;

import com.example.demo.model.Approvisionnement;
import com.example.demo.model.Client;
import com.example.demo.model.repository.ApproRepository;
import com.example.demo.model.repository.ClientRepository;
import com.example.demo.model.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    public void save(Client client){
        clientRepository.save(client);
    }

    public List<Client> showAllClients(){
        return clientRepository.findAll();
    }

    public Client showOneClient(int id){
        return clientRepository.findById(id).get();
    }
    public void delete(int id)
    {
        if(showOneClient(id)!=null)
            clientRepository.deleteById(id);
    }
}
