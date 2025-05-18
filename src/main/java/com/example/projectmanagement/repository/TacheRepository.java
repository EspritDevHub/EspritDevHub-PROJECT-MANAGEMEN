package com.example.projectmanagement.repository;

import com.example.projectmanagement.Entities.Projet;
import com.example.projectmanagement.Entities.Tache;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TacheRepository extends MongoRepository<Tache, String> {
    List<Tache> findByProjetId(String projetId);
}
