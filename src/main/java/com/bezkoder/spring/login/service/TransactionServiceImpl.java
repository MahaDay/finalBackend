package com.bezkoder.spring.login.service;

import com.bezkoder.spring.login.models.Client;
import com.bezkoder.spring.login.models.Produit;
import com.bezkoder.spring.login.models.Transaction;
import com.bezkoder.spring.login.repository.ClientRepository;
import com.bezkoder.spring.login.repository.ProduitRepository;
import com.bezkoder.spring.login.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    ClientRepository clientRepository;

    @Override
    public void AffecterProduitATransaction(Long id_produit, Long id_transaction) {
        Transaction transaction = transactionRepository.findById(id_transaction).get();
        Produit produit = produitRepository.findById(id_produit).get();
        List<Transaction> transactions = produit.getTransactions();
        transactions.add(transaction);
        produit.setTransactions(transactions);
        produitRepository.save(produit);
    }
    @Override
    public void AffecterClientATransaction(Long id_client, Long id_transaction) {
        Transaction transaction = transactionRepository.findById(id_transaction).get();
        Client client = clientRepository.findById(id_client).get();
        List<Transaction> transactions = client.getTransactions();
        transactions.add(transaction);
        client.setTransactions(transactions);
        clientRepository.save(client);
    }

    @Override
    public Transaction creer(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> lire() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction modifier(Long id, Transaction transaction) {
        return transactionRepository.findById(id)
                .map(t -> {
                    t.setTypeTransaction(transaction.getTypeTransaction());
                    t.setMontant(transaction.getMontant());
                    t.setDate_ajout(transaction.getDate_ajout());
                    t.setMethodePaiement(transaction.getMethodePaiement());
                    t.setStatutTransaction(transaction.getStatutTransaction());
                    t.setProduit(transaction.getProduit());
                    t.setClient(transaction.getClient());
                    return transactionRepository.save(t);
                }).orElseThrow(() -> new RuntimeException("Transaction non trouvé!"));
    }

    @Override
    public String supprimer(Long id) {
        transactionRepository.deleteById(id);
        return "Transaction supprimé!";
    }
    public Optional<Transaction> retournerTransactionById(Long id){
        return transactionRepository.findById(id);
    }
}
