package com.crusadehelper.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity(name = "Crusade")
@Data
public class Crusade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Crusade_Id", columnDefinition = "int", nullable = false)
    private int id;

    @OneToMany(mappedBy = "crusade", cascade = CascadeType.ALL)
    @JsonManagedReference
    @Setter(AccessLevel.NONE)
    private List<CrusadeForce> crusadeForces = new ArrayList<>();

    public void addCrusadeForce(CrusadeForce crusadeForce) {
        crusadeForce.setCrusade(this);
        crusadeForces.add(crusadeForce);
    }
}
