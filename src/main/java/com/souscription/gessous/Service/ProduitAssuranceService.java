package com.souscription.gessous.Service;

import com.souscription.gessous.Entity.ProduitAssurance;
import com.souscription.gessous.Repository.ProduitAssuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitAssuranceService {

    @Autowired
    private ProduitAssuranceRepository produitRepository;

    public ProduitAssurance createProduit(ProduitAssurance produit) {
        return produitRepository.save(produit);
    }

    public ProduitAssurance updateProduit(int id, ProduitAssurance produit) {
        ProduitAssurance existing = produitRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        existing.setNom(produit.getNom());
        existing.setDescription(produit.getDescription());
        existing.setMontant(produit.getMontant());
        return produitRepository.save(existing);
    }

    public void deleteProduit(int id) {
        produitRepository.deleteById(id);
    }

    public List<ProduitAssurance> getAllProduits() {
        return produitRepository.findAll();
    }
}
