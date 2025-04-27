package com.example.projectmanagement.controllers;

import com.example.projectmanagement.Dtos.ProjetDTO;
import com.example.projectmanagement.iservices.IProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/projets")
public class ProjetController {

    @Autowired
    private IProjetService projetService;

    @PostMapping
    public ProjetDTO createProjet(@RequestBody ProjetDTO projetDTO) {
        return projetService.createProjet(projetDTO);
    }

    @GetMapping("/{id}")
    public ProjetDTO getProjetById(@PathVariable String id) {
        return projetService.getProjetById(id);
    }

    @GetMapping
    public List<ProjetDTO> getAllProjets() {
        return projetService.getAllProjets();
    }

    @PutMapping("/{id}")
    public ProjetDTO updateProjet(@PathVariable String id, @RequestBody ProjetDTO projetDTO) {
        return projetService.updateProjet(id, projetDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProjet(@PathVariable String id) {
        projetService.deleteProjet(id);
    }
}
