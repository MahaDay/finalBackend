package com.bezkoder.spring.login.service;

import com.bezkoder.spring.login.models.Client;
import com.bezkoder.spring.login.models.Produit;
import com.bezkoder.spring.login.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ProduitServiceImpl implements ProduitService{
    private final ProduitRepository produitRepository;
    @Override
    public Produit creer(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> lire() {
        return produitRepository.findAll();
    }

    @Override
    public Produit modifier(Long id, Produit produit) {
        return produitRepository.findById(id)
                .map(p-> {
                    p.setNom(produit.getNom());
                    p.setPrix(produit.getPrix());
                    p.setCategorie(produit.getCategorie());
                    p.setDescription(produit.getDescription());
                    p.setCode_produit(produit.getCode_produit());
                    return produitRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Produit non trouvé!"));
    }

    @Override
    public String supprimer(Long id) {
        produitRepository.deleteById(id);
        return "Produit supprimé!";
    }
    public Optional<Produit> retournerProduitById(Long id){
        return produitRepository.findById(id);
    }
}
