package com.crusadehelper.entities;

import com.crusadehelper.enums.faction.Faction;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity(name = "CrusadeForce")
@Data
@ApiModel(description = "A force participating in a crusade")
public class CrusadeForce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Crusade_Force_Id", columnDefinition = "int", nullable = false)
    @ApiModelProperty(notes = "The auto-generated ID for the crusade force")
    private int id;

    @Column(name = "Name", columnDefinition = "nvarchar(255)", nullable = false)
    @ApiModelProperty(notes = "The crusade force's name")
    private String name;

    @Column(name = "Player_Name", columnDefinition = "nvarchar(255)", nullable = false)
    @ApiModelProperty(notes = "The name of the player to which the crusade force belongs")
    private String playerName;

    @Column(name = "Faction", columnDefinition = "nvarchar(255)", nullable = false)
    @ApiModelProperty(notes = "The faction to which the crusade force belongs")
    private Faction faction;

    @Column(name = "Battle_Tally", columnDefinition = "int", nullable = false)
    @ApiModelProperty(notes = "The number of battles that the crusade force has waged")
    private int battleTally = 0;

    @Column(name = "Victories", columnDefinition = "int", nullable = false)
    @ApiModelProperty(notes = "The number of battles that the crusade force has won")
    private int victories = 0;

    @Column(name = "Requisition_Points", columnDefinition = "int", nullable = false)
    @ApiModelProperty(notes = "The number of requisition points available to the crusade force")
    private int requisitionPoints = 0;

    @Column(name = "Supply_Limit", columnDefinition = "int", nullable = false)
    @ApiModelProperty(notes = "The crusade force's supply limit")
    private int supplyLimit = 0;

    @Column(name = "Supply_Used", columnDefinition = "int", nullable = false)
    @ApiModelProperty(notes = "The number of supply points that the crusade force has used")
    private int supplyUsed = 0;


    @OneToMany(mappedBy = "crusadeForce", cascade = CascadeType.ALL)
    @JsonManagedReference
    @Setter(AccessLevel.NONE)
    @ApiModelProperty(notes = "The crusade cards belonging to the crusade force")
    private List<CrusadeCard> crusadeCards = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "Crusade_Id",referencedColumnName = "crusade_id")
    @ToString.Exclude
    @JsonBackReference
    @ApiModelProperty(notes = "The crusade to which the crusade force belongs to")
    private Crusade crusade;

    public void addCrusadeCard(CrusadeCard card) {
        crusadeCards.add(card);
        card.setCrusadeForce(this);
    }
}
