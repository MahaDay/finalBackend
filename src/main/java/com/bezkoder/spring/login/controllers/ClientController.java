package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.models.Client;
import com.bezkoder.spring.login.repository.ClientRepository;
import com.bezkoder.spring.login.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/client")

public class ClientController {
    @Autowired

    private ClientService clientService;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/Mlle")
    public int cMlle(){
        return clientRepository.cMlle().size();
    }

    @GetMapping("/stats")
    public int getClients22(){
        return clientRepository.userIn23().size();
    }

    @GetMapping("/status")
    public int getClients23(){
        return clientRepository.userIn23().size();
    }



    @GetMapping("/Mme")
    public int cMme(){
        return clientRepository.cMme().size();
    }
    @GetMapping("/Mr")
    public int cMr(){
        return clientRepository.cMr().size();
    }
    @GetMapping("/Dr")
    public int cDr(){
        return clientRepository.cDr().size();
    }
    @GetMapping("/nbClient")
    public int getNombre(){
        return clientRepository.nbClient().size();
    }

    @PostMapping("/create")
    public Client create(@RequestBody Client client) {
        return clientService.creer(client);
    }

    @GetMapping("/read")
    public List<Client> read() {
        return clientService.lire();
    }

    @PutMapping("/update/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client client) {
        return clientService.modifier(id, client);
    }

    @DeleteMapping("/delete/{id}")
    public String detete(@PathVariable Long id) {
        return clientService.supprimer(id);
    }
    @GetMapping("/retournerClient/{id}")
    public Optional<Client> retournerClientById(@PathVariable Long id){
        return clientService.retournerClientById(id);
    }
}
