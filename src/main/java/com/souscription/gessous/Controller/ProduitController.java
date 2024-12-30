package com.souscription.gessous.Controller;

import com.souscription.gessous.Entity.ProduitAssurance;
import com.souscription.gessous.Service.ProduitAssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitAssuranceService produitService;

    @PostMapping
    public ResponseEntity<ProduitAssurance> createProduit(@RequestBody ProduitAssurance produit) {
        return ResponseEntity.ok(produitService.createProduit(produit));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProduitAssurance> updateProduit(@PathVariable int id, @RequestBody ProduitAssurance produit) {
        return ResponseEntity.ok(produitService.updateProduit(id, produit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable int id) {
        produitService.deleteProduit(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProduitAssurance>> getAllProduits() {
        return ResponseEntity.ok(produitService.getAllProduits());
    }
}
