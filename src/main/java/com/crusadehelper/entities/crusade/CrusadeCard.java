package com.crusadehelper.entities.crusade;

import com.crusadehelper.entities.battlescars.BattleScar;
import com.crusadehelper.enums.faction.Faction;
import com.crusadehelper.enums.rank.Rank;
import com.crusadehelper.enums.unittype.UnitType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity(name = "CrusadeCard")
@Data
@ApiModel(description = "A crusade card describing a unit")
public class CrusadeCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Crusade_Card_Id", columnDefinition = "int", nullable = false)
    @ApiModelProperty(notes = "The auto-generated ID for the crusade card")
    private int id;

    @Column(name = "Unit_Name", columnDefinition = "nvarchar(255)", nullable = false)
    @NonNull
    @ApiModelProperty(notes = "The unit's name (player-defined)")
    private String unitName;

    @Column(name = "Faction", columnDefinition = "nvarchar(255)", nullable = false)
    @NonNull
    @ApiModelProperty(notes = "The unit's faction")
    private Faction faction;

    @Column(name = "Unit_Type", columnDefinition = "nvarchar(255)", nullable = false)
    @NonNull
    @ApiModelProperty(notes = "The unit's type")
    private UnitType unitType;

    @Column(name = "Battlefield_Role", columnDefinition = "nvarchar(255)")
    @ApiModelProperty(notes = "The unit's battlefield role (player-defined)")
    private String battlefieldRole;

    //TODO: List<Keywords> selectableKeywords -> Keywords entity need to be created at some point. Single string for now
    //TODO: Fix ApiModelProperty notes once keywords entity exists
    @Column(name = "Selectable_Keywords", columnDefinition = "nvarchar(255)")
    @ApiModelProperty(notes = "Da keywords")
    private String selectableKeywords;

    @Column(name = "Power_Rating", columnDefinition = "int")
    @ApiModelProperty(notes = "The unit's power rating")
    private int powerRating = 0;

    @Column(name = "Experience_Points", columnDefinition = "int")
    @ApiModelProperty(notes = "The unit's current XP points")
    private int experiencePoints = 0;

    @Column(name = "Crusade_Points", columnDefinition = "int")
    @ApiModelProperty(notes = "The unit's current crusade points")
    private int crusadePoints = 0;

    @Column(name = "Equipment", columnDefinition = "nvarchar(255)")
    @ApiModelProperty(notes = "The unit's current equipment")
    private String equipment;

    @Column(name = "Psychic_Powers", columnDefinition = "nvarchar(255)")
    @ApiModelProperty(notes = "The unit's current psychic powers")
    private String psychicPowers;

    @Column(name = "Warlord_Traits", columnDefinition = "nvarchar(255)")
    @ApiModelProperty(notes = "The unit's current warlord trait")
    private String warlordTraits;

    @Column(name = "Relics", columnDefinition = "nvarchar(255)")
    @ApiModelProperty(notes = "The unit's current relics")
    private String relics;

    @Column(name = "Battles_Played", columnDefinition = "int")
    @ApiModelProperty(notes = "The number of battles the unit has participated in")
    private int battlesPlayed = 0;

    @OneToMany(mappedBy = "crusadeCard", cascade = CascadeType.ALL)
    @Setter(AccessLevel.NONE)
    @ApiModelProperty(notes = "The unit's combat tallies")
    List<CombatTally> combatTallies = new ArrayList<>();

    @Column(name = "Rank", columnDefinition = "nvarchar(255)")
    @ApiModelProperty(notes = "The unit's current rank")
    private Rank rank;

    @Column(name = "Battle_Honours", columnDefinition = "nvarchar(255)")
    @ApiModelProperty(notes = "The unit's current battle honours")
    private String battleHonours;

    @OneToMany(mappedBy = "crusadeCard", cascade = CascadeType.ALL)
    @Setter(AccessLevel.NONE)
    @ApiModelProperty(notes = "The unit's current battle scars")
    private List<BattleScar> battleScars = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "crusade_force_id", referencedColumnName = "crusade_force_id", nullable = false)
    @JsonBackReference
    @ApiModelProperty(notes = "The crusade force to which this unit belongs")
    @ToString.Exclude
    private CrusadeForce crusadeForce;

    protected CrusadeCard() {
    }

    public CrusadeCard(String unitName, Faction faction, UnitType unitType) {
        this.unitName = unitName;
        this.faction = faction;
        this.unitType = unitType;
    }

    public void addCombatTally(CombatTally tally) {
        tally.setCrusadeCard(this);
        this.combatTallies.add(tally);
    }

    public void addBattleScar(BattleScar scar) {
        scar.setCrusadeCard(this);
        this.battleScars.add(scar);
    }

}
