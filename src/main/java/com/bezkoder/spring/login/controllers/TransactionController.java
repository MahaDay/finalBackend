package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.models.Client;
import com.bezkoder.spring.login.models.LastMonths;
import com.bezkoder.spring.login.models.Transaction;
import com.bezkoder.spring.login.repository.TransactionRepository;
import com.bezkoder.spring.login.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/transaction")

public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @Autowired
    private TransactionRepository transactionRepository;






    @GetMapping("/sommeTransaction")
    public int getSomme(){
        return transactionRepository.sommeTransaction();
    }

    @GetMapping("/date-ajout")
    public List<Transaction> getDateAjout() {
        return transactionRepository.dateAjout();
    }

    @GetMapping("/vente_integre")
    public int getType(){
        return transactionRepository.name().size();
    }
    @GetMapping("/nbTransaction")
    public int getNombre(){
        return transactionRepository.nbTransaction().size();
    }
    @GetMapping("/non_selectionee")
    public int getNonSelectionnee(){
        return transactionRepository.non_selectionee().size();
    }
    @GetMapping("/services")
    public int getServices(){
        return transactionRepository.services().size();
    }
    @GetMapping("/service_apre_vente")
    public int getServiceApreVente(){
        return transactionRepository.service_apre_vente().size();
    }

    @PostMapping("/create")
    public Transaction create(@RequestBody Transaction transaction) {
        return transactionService.creer(transaction);
    }

    @GetMapping("/read")
    public List<Transaction> read() {
        return transactionService.lire();
    }
    @GetMapping("/lastFive")
    public List<Transaction>getTransactionLastFive(){
        return transactionRepository.transactionLastFive();


    }

    @PutMapping("/update/{id}")
    public Transaction update(@PathVariable Long id, @RequestBody Transaction transaction) {
        return transactionService.modifier(id, transaction);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return transactionService.supprimer(id);
    }

    @GetMapping("/retournerTransaction/{id}")
    public Optional<Transaction> retournerTransactionById(@PathVariable Long id){
        return transactionService.retournerTransactionById(id);
    }

    @GetMapping("/lastmonth")
    public String getLastMonth() {
        Map<String,Integer> res = new HashMap<>();
        for(int ij= 1; ij<32;ij++){
            res.put(String.valueOf(ij),0);
        }
        for (Transaction trans : transactionRepository.transactionLastMonth()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(trans.getDate_ajout());
            res.put(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)),res.get(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)))+1);
        }

        return  "{"+res.entrySet().stream()
                .map(e -> "\""+ e.getKey() + "\":\"" + String.valueOf(e.getValue()) + "\"")
                .collect(Collectors.joining(", "))+"}";
    }

    @GetMapping("/lastday")
    public int getLastDay() {

        Map<String,Integer> res = new HashMap<>();
        for(int ij= 0; ij<24;ij++){
            res.put(String.valueOf(ij),0);
        }
        for (Transaction trans : transactionRepository.transactionLastDay()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(trans.getDate_ajout());
            res.put(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)),res.get(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)))+1);
        }

        return transactionRepository.transactionLastDay().size();
    }

    @GetMapping("/lastyear")
    public LastMonths getLastYear() {
        LastMonths result = new LastMonths();

        for (Transaction trans : transactionRepository.transactionLastYear()){
            if (trans.getDate_ajout().getMonth()==0){
                result.january =result.january +1;
            }
            if (trans.getDate_ajout().getMonth()==1){
                result.february =result.february +1;
            }
            if (trans.getDate_ajout().getMonth()==2){
                result.march =result.march +1;
            }
            if (trans.getDate_ajout().getMonth()==3){
                result.april =result.april +1;
            }
            if (trans.getDate_ajout().getMonth()==4){
                result.may =result.may +1;
            }
            if (trans.getDate_ajout().getMonth()==5){
                result.june =result.june +1;
            }
            if (trans.getDate_ajout().getMonth()==6){
                result.july =result.july +1;
            }
            if (trans.getDate_ajout().getMonth()==7){
                result.august =result.august +1;
            }
            if (trans.getDate_ajout().getMonth()==8){
                result.october =result.october +1;
            }
            if (trans.getDate_ajout().getMonth()==9){
                result.september =result.september +1;
            }
            if (trans.getDate_ajout().getMonth()==10){
                result.november =result.november +1;
            }
            if (trans.getDate_ajout().getMonth()==11){
                result.december =result.december +1;
            }
        }
        return result;

    }

}
