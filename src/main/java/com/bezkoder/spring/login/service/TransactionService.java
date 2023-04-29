package com.bezkoder.spring.login.service;

import com.bezkoder.spring.login.models.Produit;
import com.bezkoder.spring.login.models.Transaction;

import java.util.List;
import java.util.Optional;


public interface TransactionService {
    public void AffecterProduitATransaction (Long id_produit , Long id_transaction);

    public void AffecterClientATransaction(Long id_client, Long id_transaction);

    Transaction creer(Transaction transaction);
    List<Transaction> lire();
    Transaction modifier(Long id, Transaction transaction);
    String supprimer(Long id);
    Optional<Transaction> retournerTransactionById(Long id);
}
