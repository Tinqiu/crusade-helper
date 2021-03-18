package com.crusadehelper.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "CrusadeForce")
@Data
public class CrusadeForce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int", nullable = false)
    private int id;
}
