package com.bezkoder.spring.login.service;

import com.bezkoder.spring.login.models.Adresse;
import com.bezkoder.spring.login.models.Role;
import com.bezkoder.spring.login.repository.AdresseRepository;
import com.bezkoder.spring.login.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public Role creer(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> lire() {
        return roleRepository.findAll();
    }

    @Override
    public Role modifier(Long id, Role role) {
        return roleRepository.findById(id)
                .map(r->{
                    r.setCommentaire(role.getCommentaire());
                    return roleRepository.save(r);
                }).orElseThrow(()-> new RuntimeException("Role non trouvé!"));
    }

    @Override
    public String supprimer(Long id) {
        roleRepository.deleteById(id);
        return "Role supprimé!";
    }
}
