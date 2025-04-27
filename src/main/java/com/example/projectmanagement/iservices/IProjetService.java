package com.example.projectmanagement.iservices;

import com.example.projectmanagement.Dtos.ProjetDTO;

import java.util.List;

public interface IProjetService {

    ProjetDTO createProjet(ProjetDTO projetDTO);
    ProjetDTO updateProjet(String id, ProjetDTO projetDTO);
    ProjetDTO getProjetById(String id);
    List<ProjetDTO> getAllProjets();
    void deleteProjet(String id);
}
