package com.example.projectmanagement.Dtos;

import com.example.projectmanagement.Entities.Enums.EtatProjetEnum;
import com.example.projectmanagement.Entities.Enums.EtapeManagementEnum;
import com.example.projectmanagement.Entities.Enums.EtapeProjetEnum;
import com.example.projectmanagement.Entities.Projet;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ProjetDTO {
    private String id;

    private String code;
    private String titre;
    private String description;

    private EtatProjetEnum etat;
    private EtapeManagementEnum etapeManagement;
    private EtapeProjetEnum etapeProjet;

    private LocalDate dateDeb;
    private LocalDate dateFin;

    private LocalDate dateDebPrevu;
    private LocalDate dateFinPrevu;

    private String portefeuilleId;
    private String programmeId;
    private String typeProjet;

    private String fournisseurId;
    private String sponsorId;
    private String chefDeProjetId;
    private String clientId;

    private Long createdBy;
    private LocalDate creationDate;

    public ProjetDTO(Projet projet) {
        this.id = projet.getId();
        this.code = projet.getCode();
        this.titre = projet.getTitre();
        this.description = projet.getDescription();
        this.etat = projet.getEtat();
        this.etapeManagement = projet.getEtapeManagement();
        this.etapeProjet = projet.getEtapeProjet();
        this.dateDeb = projet.getDateDeb();
        this.dateFin = projet.getDateFin();
        this.dateDebPrevu = projet.getDateDebPrevu();
        this.dateFinPrevu = projet.getDateFinPrevu();
        this.portefeuilleId = projet.getPortefeuilleId();
        this.programmeId = projet.getProgrammeId();
        this.typeProjet = projet.getTypeProjet();
        this.fournisseurId = projet.getFournisseurId();
        this.sponsorId = projet.getSponsorId();
        this.chefDeProjetId = projet.getChefDeProjetId();
        this.clientId = projet.getClientId();
        this.createdBy = projet.getCreatedBy();
        this.creationDate = projet.getCreationDate();
    }
}
