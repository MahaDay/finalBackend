package com.bezkoder.spring.login.service;

import com.bezkoder.spring.login.models.User;

import java.util.List;

public interface UserService {
    User creer(User user);
    List<User> lire();
    User modifier(Long id, User user);
    String supprimer(Long id);
}
