package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    @Query(value =" SELECT SUM(prix) FROM produit", nativeQuery = true)
    public int sommeProduit();
    
    @Query(value = "SELECT * FROM produit  WHERE prix BETWEEN 200 AND 300", nativeQuery = true)
    public List<Produit> prodPrix();


    @Query(value = " SELECT * FROM produit  WHERE nom = 'Xyz'" , nativeQuery = true)
    public List<Produit> name();
    @Query(value = "SELECT * FROM produit", nativeQuery = true)
    public List<Produit> nbProduit();

}
