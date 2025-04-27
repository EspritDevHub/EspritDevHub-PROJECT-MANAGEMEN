package com.example.projectmanagement.repository;

import com.example.projectmanagement.Entities.Projet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProjetRepository extends MongoRepository<Projet, String> {
    boolean existsByCode(String code);
    List<Projet> findByIdEncadrant(String idEncadrant);
}