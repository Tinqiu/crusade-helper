package com.crusadehelper.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "CrusadeForce")
@Data
public class CrusadeForce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "crusade_force_id", columnDefinition = "int", nullable = false)
    private int id;

    @OneToMany(mappedBy = "crusadeForce", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<CrusadeCard> crusadeCards = new ArrayList<>();

    public void addCrusadeCard(CrusadeCard card){
        crusadeCards.add(card);
        card.setCrusadeForce(this);
    }
}
