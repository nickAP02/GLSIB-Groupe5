package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Client")
public class clientController {
    @Autowired
    ClientService clientService;
    @GetMapping("/All")
    public String GetAllClient(Model model) {
        model.addAttribute("clients",clientService.showAllClients());
        return "Client/showAllClient";
    }


    @PostMapping("/Create")
    public String addClient(Client client) {
        clientService.save(client);
        return "Client/client";
    }

    @GetMapping("/Find/{id}")
    public String TrouverClientbyId(@PathVariable("id") int id,Model model){
        model.addAttribute("client",clientService.showOneClient(id));
        return "Client/modification";
    }

    /*@PutMapping("/Update")
    public String UpdateClient(@PathVariable("id" int id)){
        Client updateClient = clientService.UpdateClient(client);
        return "Client/modification";

    }*/

    @DeleteMapping("/Delete/{id}")
    public String DeleteClient(@PathVariable("id_Client") int idClient){
        clientService.delete(idClient);
        return "Client/suppression";
    }
}
