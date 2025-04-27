package com.example.projectmanagement.services;

import com.example.projectmanagement.Dtos.ProjetDTO;
import com.example.projectmanagement.Entities.Projet;
import com.example.projectmanagement.iservices.IProjetService;
import com.example.projectmanagement.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PorjetService implements IProjetService {


    @Autowired
    private ProjetRepository projetRepository;

    @Override
    public ProjetDTO createProjet(ProjetDTO projetDTO) {
        Projet projet = new Projet(projetDTO);
        projet = projetRepository.save(projet);
        return new ProjetDTO(projet);
    }

    @Override
    public ProjetDTO updateProjet(String id, ProjetDTO projetDTO) {
        Projet projet = projetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projet not found"));
        // Update fields
        projet.setCode(projetDTO.getCode());
        projet.setTitre(projetDTO.getTitre());
        projet.setDescription(projetDTO.getDescription());
        projet.setEtat(projetDTO.getEtat());
        projet.setEtapeManagement(projetDTO.getEtapeManagement());
        projet.setEtapeProjet(projetDTO.getEtapeProjet());
        projet.setDateDeb(projetDTO.getDateDeb());
        projet.setDateFin(projetDTO.getDateFin());
        projet.setDateDebPrevu(projetDTO.getDateDebPrevu());
        projet.setDateFinPrevu(projetDTO.getDateFinPrevu());
        projet.setPortefeuilleId(projetDTO.getPortefeuilleId());
        projet.setProgrammeId(projetDTO.getProgrammeId());
        projet.setTypeProjet(projetDTO.getTypeProjet());
        projet.setFournisseurId(projetDTO.getFournisseurId());
        projet.setSponsorId(projetDTO.getSponsorId());
        projet.setChefDeProjetId(projetDTO.getChefDeProjetId());
        projet.setClientId(projetDTO.getClientId());
        projet.setCreatedBy(projetDTO.getCreatedBy());
        projet.setCreationDate(projetDTO.getCreationDate());

        projet = projetRepository.save(projet);
        return new ProjetDTO(projet);
    }

    @Override
    public ProjetDTO getProjetById(String id) {
        Projet projet = projetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projet not found"));
        return new ProjetDTO(projet);
    }

    @Override
    public List<ProjetDTO> getAllProjets() {
        List<Projet> projets = projetRepository.findAll();
        return projets.stream()

                .map((Projet t) -> new ProjetDTO((Projet) projets))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProjet(String id) {
        projetRepository.deleteById(id);
    }
}
