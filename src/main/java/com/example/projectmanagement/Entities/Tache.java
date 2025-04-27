package com.example.projectmanagement.Entities;

import com.example.projectmanagement.Dtos.TacheDTO;
import com.example.projectmanagement.Entities.Enums.EtatTacheEnum;
import com.example.projectmanagement.Entities.Enums.TypeCoutEnum;
import com.example.projectmanagement.Entities.Enums.TypeDureeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;

@Document(collection = "activites")
@Data
@NoArgsConstructor
public class Tache {

    @Id
    private String id;

    private String titre;
    private String description;
    private Float duree;
    private Float cout;
    private LocalDateTime dateDebPlanif;
    private LocalDateTime dateFinPlanif;
    private LocalDateTime dateDeb;
    private LocalDateTime dateFin;
    private EtatTacheEnum etat;
    private TypeDureeEnum typeDuree;
    private TypeCoutEnum typeCout;

    private Integer avancementTache;



    public Tache(TacheDTO tacheDTO) {
        this.id = tacheDTO.getId();
        this.titre = tacheDTO.getTitre();
        this.description = tacheDTO.getDescription();
        this.duree = tacheDTO.getDuree();
        this.cout = tacheDTO.getCout();
        this.dateDebPlanif = tacheDTO.getDateDebPlanif();
        this.dateFinPlanif = tacheDTO.getDateFinPlanif();
        this.dateDeb = tacheDTO.getDateDeb();
        this.dateFin = tacheDTO.getDateFin();
        this.etat = tacheDTO.getEtat();
        this.typeDuree = tacheDTO.getTypeDuree();
        this.typeCout = tacheDTO.getTypeCout();
        this.avancementTache = tacheDTO.getAvancementTache();
    }
}
