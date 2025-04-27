package com.example.projectmanagement.Dtos;

import com.example.projectmanagement.Entities.Enums.EtatTacheEnum;
import com.example.projectmanagement.Entities.Enums.TypeCoutEnum;
import com.example.projectmanagement.Entities.Enums.TypeDureeEnum;
import com.example.projectmanagement.Entities.Tache;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TacheDTO {
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


    //SH
    public TacheDTO(Tache tache){
        return ;
    }
}
