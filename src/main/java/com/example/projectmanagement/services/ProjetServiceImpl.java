package com.example.projectmanagement.services;


import com.example.projectmanagement.Dtos.ProjetDTO;
import com.example.projectmanagement.Entities.Projet;
import com.example.projectmanagement.repository.GroupeRepository;
import com.example.projectmanagement.repository.ProjetRepository;
import com.example.projectmanagement.iservices.IProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import com.example.projectmanagement.Dtos.PhaseDTO;
import com.example.projectmanagement.Dtos.ProjetDTO;
import com.example.projectmanagement.Entities.Groupe;
import com.example.projectmanagement.Entities.Phase;
import com.example.projectmanagement.Entities.Projet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjetServiceImpl implements IProjetService {

    private final ProjetRepository projetRepository;
    private final GroupeRepository groupeRepository;

    @Override
    public ProjetDTO createProjet(ProjetDTO projetDTO) {
        Projet projet = convertToEntity(projetDTO);
        Projet saved = projetRepository.save(projet);
        return convertToDTO(saved);
    }

    @Override
    public ProjetDTO updateProjet(String id, ProjetDTO projetDTO) {
        Optional<Projet> existing = projetRepository.findById(id);
        if (existing.isPresent()) {
            Projet projet = convertToEntity(projetDTO);
            projet.setId(id); // Ensure we're updating the correct entity
            Projet updated = projetRepository.save(projet);
            return convertToDTO(updated);
        }
        throw new RuntimeException("Projet not found with id: " + id);
    }

    @Override
    public ProjetDTO getProjetById(String id) {
        Projet projet = projetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projet not found with id: " + id));
        return convertToDTO(projet);
    }

    @Override
    public List<ProjetDTO> getAllProjets() {
        return projetRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProjet(String id) {
        projetRepository.deleteById(id);
    }

    // === Conversion methods ===

    private Projet convertToEntity(ProjetDTO dto) {
        Projet projet = new Projet();

        projet.setId(dto.getId());
        projet.setCode(dto.getCode());
        projet.setTitre(dto.getTitre());
        projet.setDescription(dto.getDescription());
        projet.setEtat(dto.getEtat());
        projet.setEtapeProjet(dto.getEtapeProjet());
        projet.setDateDebut(dto.getDateDebut());
        projet.setDateFinPrevu(dto.getDateFinPrevu());
        projet.setCreatedBy(dto.getCreatedBy());
        projet.setCreationDate(dto.getCreationDate());

        // Convert phases
        if (dto.getJalons() != null) {
            projet.setJalons(dto.getJalons().stream().map(this::convertToEntity).collect(Collectors.toList()));
        }

        // If you want to associate a group manually, uncomment and manage it with a GroupId in the DTO
        // For example, if you add: private String groupeId; in ProjetDTO
        // Optional<Groupe> groupe = groupeRepository.findById(dto.getGroupeId());
        // groupe.ifPresent(projet::setGroupe);

        return projet;
    }

    private ProjetDTO convertToDTO(Projet projet) {
        ProjetDTO dto = new ProjetDTO();

        dto.setId(projet.getId());
        dto.setCode(projet.getCode());
        dto.setTitre(projet.getTitre());
        dto.setDescription(projet.getDescription());
        dto.setEtat(projet.getEtat());
        dto.setEtapeProjet(projet.getEtapeProjet());
        dto.setDateDebut(projet.getDateDebut());
        dto.setDateFinPrevu(projet.getDateFinPrevu());
        dto.setCreatedBy(projet.getCreatedBy());
        dto.setCreationDate(projet.getCreationDate());

        if (projet.getJalons() != null) {
            dto.setJalons(projet.getJalons().stream().map(this::convertToDTO).collect(Collectors.toList()));
        }

        return dto;
    }

    private Phase convertToEntity(PhaseDTO dto) {
        Phase phase = new Phase();
        phase.setId(dto.getId());
        phase.setNom(dto.getNom());
        phase.setDateDebut(dto.getDateDebut());
        phase.setDateFin(dto.getDateFin());
        return phase;
    }

    private PhaseDTO convertToDTO(Phase entity) {
        return new PhaseDTO(
                entity.getId(),
                entity.getNom(),
                entity.getDateDebut(),
                entity.getDateFin()
        );
    }
}