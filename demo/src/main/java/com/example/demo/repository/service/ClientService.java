package com.example.demo.repository.service;


import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public void saveClient(Client client){
        clientRepository.save(client);
    }

    public List<Client> showClients(){
        return clientRepository.findAll();
    }

    public Client showClient(int id){
        Optional<Client> optional= clientRepository.findById(id);
        Client client = null;
        if (optional.isPresent()){
            client = optional.get();
        }
        else {
            return client;
        }
        return client;
    }

    public void deleteClient(int id){
        if (showClient(id)!= null){
            clientRepository.deleteById(id);
        }
    }

    public void updateClient(Client client){
        clientRepository.notify();
    }
}
