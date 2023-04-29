package com.bezkoder.spring.login.service;

import com.bezkoder.spring.login.models.Adresse;
import com.bezkoder.spring.login.repository.AdresseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class AdresseServiceImpl implements AdresseService {
    private final AdresseRepository adresseRepository;
    @Override
    public Adresse creer(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    @Override
    public List<Adresse> lire() {
        return adresseRepository.findAll();
    }

    @Override
    public Adresse modifier(Long id, Adresse adresse) {
        return adresseRepository.findById(id)
                .map(a->{
                    a.setVille(adresse.getVille());
                    a.setPays(adresse.getPays());
                    a.setAvenu(adresse.getAvenu());
                    a.setCode_postal(adresse.getCode_postal());
                    return adresseRepository.save(a);
                }).orElseThrow(()-> new RuntimeException("Adresse non trouvé!"));
    }

    @Override
    public String supprimer(Long id) {
        adresseRepository.deleteById(id);
        return "Adresse supprimé!";
    }
}
