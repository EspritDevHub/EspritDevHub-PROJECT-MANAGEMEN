package com.example.projectmanagement.Dtos;

import com.example.projectmanagement.Entities.Enums.EtatProjetEnum;
import com.example.projectmanagement.Entities.Enums.EtapeManagementEnum;
import com.example.projectmanagement.Entities.Enums.EtapeProjetEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
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
}
