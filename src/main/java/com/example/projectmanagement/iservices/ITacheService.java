package com.example.projectmanagement.iservices;

import com.example.projectmanagement.Dtos.TacheDTO;

import java.util.List;

public interface ITacheService {

    TacheDTO createTache(TacheDTO TacheDTO);
    TacheDTO updateTache(String id, TacheDTO TacheDTO);
    TacheDTO getTacheById(String id);
    List<TacheDTO> getAllTaches();
    void deleteTache(String id);
}
