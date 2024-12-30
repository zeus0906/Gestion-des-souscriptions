package com.souscription.gessous.Service;

import com.souscription.gessous.Entity.ProduitAssurance;
import com.souscription.gessous.Entity.Souscription;
import com.souscription.gessous.Repository.ProduitAssuranceRepository;
import com.souscription.gessous.Repository.SouscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SouscriptionService {

    @Autowired
    private SouscriptionRepository souscriptionRepository;

    public ProduitAssurance createSouscription(Souscription souscription) {
        return souscriptionRepository.save(souscription).getProduit();
    }

    public ProduitAssurance updateSouscription(Long id, Souscription souscription) {
        Souscription existing = souscriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        existing.setDateSouscription(souscription.getDateSouscription());
        existing.setDateDebutSouscription(souscription.getDateDebutSouscription());
        existing.setDateFinSouscription(souscription.getDateFinSouscription());
        return souscriptionRepository.save(existing).getProduit();
    }

    public void deleteSouscription(Long id) {
        souscriptionRepository.deleteById(id);
    }

    public List<Souscription> getAllASouscriptions() {
        return souscriptionRepository.findAll();
    }
}
