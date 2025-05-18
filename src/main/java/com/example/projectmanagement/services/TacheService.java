package com.example.projectmanagement.services;


import com.example.projectmanagement.Dtos.TacheDTO;
import com.example.projectmanagement.Entities.Tache;
import com.example.projectmanagement.iservices.ITacheService;
import com.example.projectmanagement.repository.TacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TacheService implements ITacheService {

    private final TacheRepository tacheRepository;

    @Override
    public TacheDTO createTache(TacheDTO tacheDTO) {
        Tache tache = new Tache(tacheDTO);
        return convertToDTO(tacheRepository.save(tache));
    }

    @Override
    public TacheDTO updateTache(String id, TacheDTO tacheDTO) {
        Tache existing = tacheRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tâche non trouvée avec ID : " + id));
        Tache updatedTache = new Tache(tacheDTO);
        updatedTache.setId(id);
        return convertToDTO(tacheRepository.save(updatedTache));
    }

    @Override
    public TacheDTO getTacheById(String id) {
        Tache tache = tacheRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tâche non trouvée avec ID : " + id));
        return convertToDTO(tache);
    }

    @Override
    public List<TacheDTO> getAllTaches() {
        return tacheRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTache(String id) {
        tacheRepository.deleteById(id);
    }

    @Override
    public List<TacheDTO> getTachesByProjet(String projetId) {
        List<Tache> taches = tacheRepository.findByProjetId(projetId);

        // Retourner une liste vide si aucune tâche n'est trouvée
        return taches.isEmpty() ? List.of() : taches.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }



    private TacheDTO convertToDTO(Tache tache) {
        // Conversion de l'entité Tache en DTO
        return new TacheDTO(tache);  // Utilisez le constructeur pour convertir
    }
}
