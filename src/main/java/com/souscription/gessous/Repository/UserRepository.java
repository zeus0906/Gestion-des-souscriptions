package com.conversion.truconversion.Repository;

import com.conversion.truconversion.Entite.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
