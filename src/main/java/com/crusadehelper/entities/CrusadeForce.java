package com.crusadehelper.entities;

import com.crusadehelper.enums.faction.Faction;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity(name = "CrusadeForce")
@Data
public class CrusadeForce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Crusade_Force_Id", columnDefinition = "int", nullable = false)
    private int id;

    @Column(name = "Name", columnDefinition = "nvarchar(255)", nullable = false)
    private String name;

    @Column(name = "Player_Name", columnDefinition = "nvarchar(255)", nullable = false)
    private String playerName;

    @Column(name = "Faction", columnDefinition = "nvarchar(255)", nullable = false)
    private Faction faction;

    @Column(name = "Battle_Tally", columnDefinition = "int", nullable = false)
    private int battleTally = 0;

    @Column(name = "Victories", columnDefinition = "int", nullable = false)
    private int victories = 0;

    @Column(name = "Requisition_Points", columnDefinition = "int", nullable = false)
    private int requisitionPoints = 0;

    @Column(name = "Supply_Limit", columnDefinition = "int", nullable = false)
    private int supplyLimit = 0;

    @Column(name = "Supply_Used", columnDefinition = "int", nullable = false)
    private int supplyUsed = 0;


    @OneToMany(mappedBy = "crusadeForce", cascade = CascadeType.ALL)
    @JsonManagedReference
    @Setter(AccessLevel.NONE)
    private List<CrusadeCard> crusadeCards = new ArrayList<>();

    public void addCrusadeCard(CrusadeCard card){
        crusadeCards.add(card);
        card.setCrusadeForce(this);
    }
}
