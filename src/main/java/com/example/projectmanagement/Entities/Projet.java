package com.example.projectmanagement.Entities;

import com.example.projectmanagement.Dtos.ProjetDTO;
import com.example.projectmanagement.Entities.Enums.EtapeManagementEnum;
import com.example.projectmanagement.Entities.Enums.EtapeProjetEnum;
import com.example.projectmanagement.Entities.Enums.EtatProjetEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document(collection = "projets")
@Data
@NoArgsConstructor
public class Projet {

    @Id
    private String id;

    private String code;
    private String titre;
    private String description;

    private EtatProjetEnum etat;
    private EtapeProjetEnum etapeProjet;

    private LocalDate dateDeb;
    private LocalDate dateFin;

    private LocalDate dateDebPrevu;
    private LocalDate dateFinPrevu;
    private String portefeuilleId; // Instead of Portefeuille entity -> referencing by ID
    private String programmeId;    // Instead of Programme entity -> referencing by ID
    private EtapeManagementEnum etapeManagement;
    private String typeProjet;     // Instead of Vocabulaire entity -> just store the string

    private String fournisseurId;  // PartiePrenante ids
    private String sponsorId;
    private String chefDeProjetId;
    private String clientId;

    private Long createdBy;
    private LocalDate creationDate;

    public Projet(ProjetDTO projetDTO) {
        this.id = projetDTO.getId();
        this.code = projetDTO.getCode();
        this.titre = projetDTO.getTitre();
        this.description = projetDTO.getDescription();
        this.etat = projetDTO.getEtat();
        this.etapeManagement = projetDTO.getEtapeManagement();
        this.etapeProjet = projetDTO.getEtapeProjet();
        this.dateDeb = projetDTO.getDateDeb();
        this.dateFin = projetDTO.getDateFin();
        this.dateDebPrevu = projetDTO.getDateDebPrevu();
        this.dateFinPrevu = projetDTO.getDateFinPrevu();
        this.portefeuilleId = projetDTO.getPortefeuilleId();
        this.programmeId = projetDTO.getProgrammeId();
        this.typeProjet = projetDTO.getTypeProjet();
        this.fournisseurId = projetDTO.getFournisseurId();
        this.sponsorId = projetDTO.getSponsorId();
        this.chefDeProjetId = projetDTO.getChefDeProjetId();
        this.clientId = projetDTO.getClientId();
        this.createdBy = projetDTO.getCreatedBy();
        this.creationDate = projetDTO.getCreationDate();
    }
}
