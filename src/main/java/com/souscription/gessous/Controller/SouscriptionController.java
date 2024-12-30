package com.souscription.gessous.Controller;

import com.souscription.gessous.Entity.ProduitAssurance;
import com.souscription.gessous.Entity.Souscription;
import com.souscription.gessous.Service.SouscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/souscriptions")
public class SouscriptionController {

    @Autowired
    private SouscriptionService souscriptionService;

    @PostMapping
    public ResponseEntity<ProduitAssurance> createSouscription(@RequestBody Souscription souscription) {
        return ResponseEntity.ok(souscriptionService.createSouscription(souscription));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProduitAssurance> updateSouscription(@PathVariable Long id, @RequestBody Souscription souscription) {
        return ResponseEntity.ok(souscriptionService.updateSouscription(id, souscription));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSouscription(@PathVariable Long id) {
        souscriptionService.deleteSouscription(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Souscription>> getAllSouscriptions() {
        return ResponseEntity.ok(souscriptionService.getAllASouscriptions());
    }
}

