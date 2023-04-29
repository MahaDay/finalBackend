package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = " SELECT * FROM client c WHERE YEAR(c.date_naissance) = 2023" , nativeQuery = true)
    public List<Client> userIn23();
    @Query(value = " SELECT * FROM client c WHERE c.salutation = 'Mlle' " , nativeQuery = true)
    public List<Client> cMlle();
    @Query(value = " SELECT * FROM client c WHERE c.salutation = 'Mme' " , nativeQuery = true)
    public List<Client> cMme();
    @Query(value = " SELECT * FROM client c WHERE c.salutation = 'Mr' " , nativeQuery = true)
    public List<Client> cMr();
    @Query(value = " SELECT * FROM client c WHERE c.salutation = 'Dr' " , nativeQuery = true)
    public List<Client> cDr();
    @Query(value = "SELECT * FROM client", nativeQuery = true)
    public List<Client> nbClient();



}

