package com.example.projectmanagement.iservices;

import com.example.projectmanagement.Dtos.TacheDTO;

import java.util.List;

public interface ITacheService {

    TacheDTO createTache(TacheDTO tacheDTO);
    TacheDTO updateTache(String id, TacheDTO tacheDTO);
    TacheDTO getTacheById(String id);
    List<TacheDTO> getAllTaches();
    void deleteTache(String id);

    List<TacheDTO> getTachesByProjet(String projetId);
}
