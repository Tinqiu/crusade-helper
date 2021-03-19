package com.crusadehelper.entities;

import com.crusadehelper.enums.faction.Faction;
import com.crusadehelper.enums.rank.Rank;
import com.crusadehelper.enums.unittype.UnitType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity(name = "CrusadeCard")
@Data
public class CrusadeCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Crusade_Card_Id", columnDefinition = "int", nullable = false)
    private int id;

    @Column(name = "Unit_Name", columnDefinition = "nvarchar(255)", nullable = false)
    @NonNull
    private String unitName;

    @Column(name = "Faction", columnDefinition = "nvarchar(255)", nullable = false)
    @NonNull
    private Faction faction;

    @Column(name = "Unit_Type", columnDefinition = "nvarchar(255)", nullable = false)
    @NonNull
    private UnitType unitType;

    @Column(name = "Battlefield_Role", columnDefinition = "nvarchar(255)")
    private String battlefieldRole;

    //TODO: List<Keywords> selectableKeywords -> Keywords entity need to be created at some point. Single string for now
    @Column(name = "Selectable_Keywords", columnDefinition = "nvarchar(255)")
    private String selectableKeywords;

    @Column(name = "Power_Rating", columnDefinition = "int")
    private int powerRating = 0;

    @Column(name = "Experience_Points", columnDefinition = "int")
    private int experiencePoints = 0;

    @Column(name = "Crusade_Points", columnDefinition = "int")
    private int crusadePoints = 0;

    @Column(name = "Equipment", columnDefinition = "nvarchar(255)")
    private String equipment;

    @Column(name = "Psychic_Powers", columnDefinition = "nvarchar(255)")
    private String psychicPowers;

    @Column(name = "Warlord_Traits", columnDefinition = "nvarchar(255)")
    private String warlordTraits;

    @Column(name = "Relics", columnDefinition = "nvarchar(255)")
    private String relics;

    @Column(name = "Battles_Played", columnDefinition = "int")
    private int battlesPlayed = 0;

    //TODO: List<CombatTally> combatTallies -> create CombatTally entity, p.312 Core Rules

    @Column(name = "Rank", columnDefinition = "nvarchar(255)")
    private Rank rank;

    @Column(name = "Battle_Honours", columnDefinition = "nvarchar(255)")
    private String battleHonours;

    @Column(name = "Battle_Scars", columnDefinition = "nvarchar(255)")
    private String battleScars;

    @ManyToOne
    @JoinColumn(name = "crusade_force_id", referencedColumnName = "crusade_force_id", nullable = false)
    @JsonBackReference
    private CrusadeForce crusadeForce;

    public CrusadeCard(String unitName, Faction faction, UnitType unitType){
        this.unitName = unitName;
        this.faction = faction;
        this.unitType = unitType;
    }

    protected CrusadeCard(){}
}
