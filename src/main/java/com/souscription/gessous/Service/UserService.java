package com.souscription.gessous.Service;

import com.souscription.gessous.Entity.User.Utilisateur;
import com.souscription.gessous.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Nous ne retrouvons pas l'utilisateur avec pour Username : " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
    }

    /**
     * Crée un nouvel utilisateur avec un rôle par défaut (USER).
     */
    public Utilisateur createUser(Utilisateur utilisateur) {
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        utilisateur.setRole("USER"); // Rôle par défaut
        return userRepository.save(utilisateur);
    }

    /**
     * Met à jour le rôle d'un utilisateur existant.
     */
    public Utilisateur updateRole(Long id, String role) {
        Utilisateur utilisateur = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        if (!role.equals("ADMIN") && !role.equals("USER")) {
            throw new IllegalArgumentException("Rôle non valide. Utilisez 'ADMIN' ou 'USER'.");
        }
        utilisateur.setRole(role);
        return userRepository.save(utilisateur);
    }

    /**
     * Récupère tous les utilisateurs.
     */
    public List<Utilisateur> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Récupère un utilisateur par ID.
     */
    public Utilisateur getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    /**
     * Supprime un utilisateur par ID.
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
