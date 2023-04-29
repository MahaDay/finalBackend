package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.models.Client;
import com.bezkoder.spring.login.models.Produit;
import com.bezkoder.spring.login.repository.ProduitRepository;
import com.bezkoder.spring.login.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/produit")

public class ProduitController {
    @Autowired

    private ProduitService produitService;
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping("/sommeProduit")
    public int getSomme(){
        return produitRepository.sommeProduit();
    }


    @GetMapping("/stats")
    public int getProdPrix(){
        return produitRepository.prodPrix().size();
    }

    @GetMapping("/Nom")
    public int getProdNom(){
        return produitRepository.name().size();
    }
    @GetMapping("/nbProduit")
    public int getNombre(){
        return produitRepository.nbProduit().size();
    }

    @PostMapping("/create")
    public Produit create(@RequestBody Produit produit) {
        return produitService.creer(produit);
    }

    @GetMapping("/read")
    public List<Produit> read() {
        return produitService.lire();
    }

    @PutMapping("/update/{id}")
    public Produit update(@PathVariable Long id, @RequestBody Produit produit) {
        return produitService.modifier(id, produit);
    }

    @DeleteMapping("/delete/{id}")
    public String detete(@PathVariable Long id) {
        return produitService.supprimer(id);
    }

    @GetMapping("/retournerProduit/{id}")
    public Optional<Produit> retournerProduitById(@PathVariable Long id){
        return produitService.retournerProduitById(id);
    }
}
