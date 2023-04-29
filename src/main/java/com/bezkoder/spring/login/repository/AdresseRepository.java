package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {
    @Query(value = " SELECT * FROM adresse  WHERE pays = 'Tunisie'" , nativeQuery = true)
    public List<Adresse> tunisie();
    @Query(value = " SELECT * FROM adresse  WHERE pays = 'France'" , nativeQuery = true)
    public List<Adresse> france();

    @Query(value = "SELECT * FROM adresse  WHERE ville ='Sfax'", nativeQuery = true)
    public List<Adresse> sfax();
    @Query(value="SELECT c.*, a.id_adresse as adresse_id, a.avenu, a.ville, a.pays, a.code_postal FROM Client c INNER JOIN Adresse a ON c.id_adresse = a.id_adresse", nativeQuery = true)
    public List<Adresse>cAdresse();

}
