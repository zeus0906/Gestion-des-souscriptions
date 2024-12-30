package com.souscription.gessous.Controller;

import com.souscription.gessous.Entity.User.Utilisateur;
import com.souscription.gessous.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UtilisateurController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Utilisateur> createUser(@RequestBody Utilisateur utilisateur) {
        return ResponseEntity.ok(userService.createUser(utilisateur));
    }

    @PutMapping("/{id}/role")
    public ResponseEntity<Utilisateur> updateRole(@PathVariable Long id, @RequestParam String role) {
        return ResponseEntity.ok(userService.updateRole(id, role));
    }

    @GetMapping
    public ResponseEntity<List<Utilisateur>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}


