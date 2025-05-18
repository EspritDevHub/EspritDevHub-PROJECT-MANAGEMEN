package com.example.projectmanagement.repository;

import com.example.projectmanagement.Entities.Enums.EtapeProjetEnum;
import com.example.projectmanagement.Entities.Enums.EtatProjetEnum;
import com.example.projectmanagement.Entities.Projet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjetRepository extends MongoRepository<Projet, String> {

    // Méthode pour récupérer un projet par son code
    Optional<Projet> findByCode(String code);

    // Méthode pour récupérer un projet par son titre
    Optional<Projet> findByTitre(String titre);

    // Méthode pour récupérer un projet par son statut
    List<Projet> findByEtat(EtatProjetEnum etat);

    // Méthode pour récupérer un projet par son étape
    List<Projet> findByEtapeProjet(EtapeProjetEnum etapeProjet);

}
