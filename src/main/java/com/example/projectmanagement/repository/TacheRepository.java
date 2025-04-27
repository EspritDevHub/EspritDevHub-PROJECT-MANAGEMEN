package com.example.projectmanagement.repository;

import com.example.projectmanagement.Entities.Projet;
import com.example.projectmanagement.Entities.Tache;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TacheRepository extends MongoRepository<Tache, String> {
}
