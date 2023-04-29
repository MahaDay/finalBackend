package com.bezkoder.spring.login.service;

import com.bezkoder.spring.login.models.User;
import com.bezkoder.spring.login.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public User creer(User utilisateur) {
        return userRepository.save(utilisateur);
    }

    @Override
    public List<User> lire() {
        return userRepository.findAll();
    }

    @Override
    public User modifier(Long id, User user) {
        return userRepository.findById(id)
                .map(u-> {
                    u.setUsername(user.getUsername());
                    u.setEmail(user.getEmail());
                    u.setPassword(user.getPassword());
                    return userRepository.save(u);
                }).orElseThrow(()-> new RuntimeException("Utilisateur non trouvé!"));
    }

    @Override
    public String supprimer(Long id) {
        userRepository.deleteById(id);
        return "utilisateur supprimé!";
    }
}
