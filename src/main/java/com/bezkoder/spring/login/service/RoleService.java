package com.bezkoder.spring.login.service;

import com.bezkoder.spring.login.models.Adresse;
import com.bezkoder.spring.login.models.Role;

import java.util.List;

public interface RoleService {
    Role creer(Role role);
    List<Role> lire();
    Role modifier(Long id, Role role);
    String supprimer(Long id);
}
