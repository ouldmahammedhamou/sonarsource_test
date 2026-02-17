package com.sonarsource.personnage.repository;

import com.sonarsource.personnage.entity.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Couche d'accès aux données (DAO) pour les personnages.
 */
@Repository
public interface PersonnageRepository extends JpaRepository<Personnage, Integer> {
}
