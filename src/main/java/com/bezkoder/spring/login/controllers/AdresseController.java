package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.models.Adresse;
import com.bezkoder.spring.login.repository.AdresseRepository;
import com.bezkoder.spring.login.service.AdresseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/adresse")
@AllArgsConstructor

public class AdresseController {
    private final AdresseService adresseService;
    @Autowired
    private final AdresseRepository adresseRepository;

    @GetMapping("/cAdresse")
    public int cAdressse(){
        return adresseRepository.cAdresse().size();
    }



    @GetMapping("/tunisie")
    public int getTunisie(){
        return adresseRepository.tunisie().size();
    }
    @GetMapping("/france")
    public int getFrance(){
        return adresseRepository.france().size();
    }

    @GetMapping("/sfax")
    public int getSfax(){
        return adresseRepository.sfax().size();
    }
    @PostMapping("/create")
    public Adresse create(@RequestBody Adresse adresse){
        return adresseService.creer(adresse);
    }
    @GetMapping("/read")
    public List<Adresse> read() {
        return adresseService.lire();
    }
    @PutMapping("/update/{id}")
    public Adresse update(@PathVariable Long id, @RequestBody Adresse adresse){
        return adresseService.modifier(id,adresse);
    }
    @DeleteMapping("/delete")
    public String delete(@PathVariable Long id){
        return adresseService.supprimer(id);
    }
}
