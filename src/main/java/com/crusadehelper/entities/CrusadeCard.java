package com.crusadehelper.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "CrusadeCard")
@Data
public class CrusadeCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "crusade_card_id", columnDefinition = "int", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "crusade_force_id", referencedColumnName = "crusade_force_id", nullable = false)
    @JsonBackReference
    private CrusadeForce crusadeForce;
}
