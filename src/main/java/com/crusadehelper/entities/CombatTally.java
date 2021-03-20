package com.crusadehelper.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity(name = "CombatTally")
@Data
@ApiModel(description = "The unit's kill tally for a single battle")
public class CombatTally {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Combat_Tally_Id", columnDefinition = "int", nullable = false)
    private int id;

    @Column(name = "Destroyed_Ranged", columnDefinition = "int", nullable = false)
    private int unitsDestroyedRanged = 0;

    @Column(name = "Destroyed_Melee", columnDefinition = "int", nullable = false)
    private int unitsDestroyedMelee = 0;

    @Column(name = "Destroyed_Psychic", columnDefinition = "int", nullable = false)
    private int unitsDestroyedPsychic = 0;

    @ManyToOne
    @JoinColumn(name = "crusade_card_id")
    @JsonBackReference
    @ToString.Exclude
    private CrusadeCard crusadeCard;


    @Transient
    private List<String> agendas = new ArrayList<>(3);
}
