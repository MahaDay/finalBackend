package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value =" SELECT SUM(montant) FROM transaction", nativeQuery = true)
    public int sommeTransaction();

    @Query(value = " SELECT * FROM transaction  WHERE type_transaction = 'vente_integre'" , nativeQuery = true)
    public List<Transaction> name();
    @Query(value = "SELECT * FROM transaction", nativeQuery = true)
    public List<Transaction> nbTransaction();
    @Query(value = " SELECT * FROM transaction  WHERE type_transaction = 'non_selectionee'" , nativeQuery = true)
    public List<Transaction> non_selectionee();
    @Query(value = " SELECT * FROM transaction  WHERE type_transaction = 'services'" , nativeQuery = true)
    public List<Transaction> services();
    @Query(value = " SELECT * FROM transaction  WHERE type_transaction = 'service_apre_vente'" , nativeQuery = true)
    public List<Transaction> service_apre_vente();
    @Query(value = " SELECT * FROM Transaction WHERE date_ajout >= '2023-01-01'" , nativeQuery = true)
    public List<Transaction> dateAjout();

    @Query(value = "Select * from Transaction  where  date_ajout >= NOW() - INTERVAL 1 Month " , nativeQuery = true)
    public List<Transaction> transactionLastMonth();

    @Query(value = "Select * from Transaction  where date_ajout  >= NOW() - INTERVAL 3 DAY" , nativeQuery = true)
    public List<Transaction> transactionLastDay();

    @Query(value = "Select * from Transaction  where  date_ajout >= NOW() - INTERVAL 1 YEAR " , nativeQuery = true)
    public List<Transaction> transactionLastYear();

    @Query(value="Select type_transaction , id_produit , id_client , statut_transaction from Transaction ORDER BY date_ajout DESC LIMIT 5",nativeQuery = true)
    public List<Transaction> transactionLastFive();

}
