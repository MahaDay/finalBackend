package com.bezkoder.spring.login.service;

import com.bezkoder.spring.login.models.Adresse;

import java.util.List;

public interface AdresseService {
    Adresse creer(Adresse adresse);
    List<Adresse> lire();
    Adresse modifier(Long id, Adresse adresse);
    String supprimer(Long id);
}
