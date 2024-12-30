package com.souscription.gessous.Repository;

import com.souscription.gessous.Entity.Souscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SouscriptionRepository extends JpaRepository<Souscription, Long> {
}
