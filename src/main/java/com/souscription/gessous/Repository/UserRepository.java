package com.souscription.gessous.Repository;


import com.souscription.gessous.Entity.User.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByUsername(String username);

}
