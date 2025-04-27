package com.example.projectmanagement.services;

import com.example.projectmanagement.Dtos.TacheDTO;
import com.example.projectmanagement.Entities.Tache;
import com.example.projectmanagement.iservices.ITacheService;
import com.example.projectmanagement.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TacheService implements ITacheService {


    @Autowired
    private TacheRepository TacheRepository;

    @Override
    public TacheDTO createTache(TacheDTO TacheDTO) {
        Tache Tache = new Tache(TacheDTO);
        Tache = TacheRepository.save(Tache);
        return new TacheDTO(Tache);
    }

    @Override
    public TacheDTO updateTache(String id, TacheDTO TacheDTO) {
        Tache Tache = TacheRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tache not found"));
        // Update fields
        /*Tache.setCode(TacheDTO.getCode());
        Tache.setTitre(TacheDTO.getTitre());
        Tache.setDescription(TacheDTO.getDescription());
        Tache.setEtat(TacheDTO.getEtat());
        Tache.setEtapeManagement(TacheDTO.getEtapeManagement());
        Tache.setEtapeTache(TacheDTO.getEtapeTache());
        Tache.setDateDeb(TacheDTO.getDateDeb());
        Tache.setDateFin(TacheDTO.getDateFin());
        Tache.setDateDebPrevu(TacheDTO.getDateDebPrevu());
        Tache.setDateFinPrevu(TacheDTO.getDateFinPrevu());
        Tache.setPortefeuilleId(TacheDTO.getPortefeuilleId());
        Tache.setProgrammeId(TacheDTO.getProgrammeId());
        Tache.setTypeTache(TacheDTO.getTypeTache());
        Tache.setFournisseurId(TacheDTO.getFournisseurId());
        Tache.setSponsorId(TacheDTO.getSponsorId());
        Tache.setChefDeTacheId(TacheDTO.getChefDeTacheId());
        Tache.setClientId(TacheDTO.getClientId());
        Tache.setCreatedBy(TacheDTO.getCreatedBy());
        Tache.setCreationDate(TacheDTO.getCreationDate());

        Tache = TacheRepository.save(Tache);*/
        return new TacheDTO(Tache);
    }

    @Override
    public TacheDTO getTacheById(String id) {
        Tache Tache = TacheRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tache not found"));
        return new TacheDTO(Tache);
    }

    @Override
    public List<TacheDTO> getAllTaches() {
        List<Tache> Taches = TacheRepository.findAll();
        return Taches.stream()

                .map((Tache t) -> new TacheDTO((Tache) Taches))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTache(String id) {
        TacheRepository.deleteById(id);
    }
}
