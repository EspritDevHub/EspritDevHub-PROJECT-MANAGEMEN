package com.example.projectmanagement.controllers;

import com.example.projectmanagement.Dtos.ProjetDTO;
import com.example.projectmanagement.Dtos.TacheDTO;
import com.example.projectmanagement.iservices.IProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projets")
public class ProjetController {

    @Autowired
    private IProjetService projetService;

    // Création d'un projet
    @PostMapping
    public ResponseEntity<ProjetDTO> createProjet(@RequestBody ProjetDTO projetDTO) {
        ProjetDTO createdProjet = projetService.createProjet(projetDTO);
        return new ResponseEntity<>(createdProjet, HttpStatus.CREATED);
    }

    // Récupération d'un projet par son ID
    @GetMapping("/{id}")
    public ResponseEntity<ProjetDTO> getProjetById(@PathVariable String id) {
        ProjetDTO projetDTO = projetService.getProjetById(id);
        if (projetDTO != null) {
            return new ResponseEntity<>(projetDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Récupération de tous les projets
    @GetMapping
    public ResponseEntity<List<ProjetDTO>> getAllProjets() {
        List<ProjetDTO> projets = projetService.getAllProjets();
        return new ResponseEntity<>(projets, HttpStatus.OK);
    }

    // Mise à jour d'un projet
    @PutMapping("/{id}")
    public ResponseEntity<ProjetDTO> updateProjet(@PathVariable String id, @RequestBody ProjetDTO projetDTO) {
        ProjetDTO updatedProjet = projetService.updateProjet(id, projetDTO);
        if (updatedProjet != null) {
            return new ResponseEntity<>(updatedProjet, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Suppression d'un projet
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable String id) {
        projetService.deleteProjet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Suppression réussie, pas besoin de vérifier
    }


}
