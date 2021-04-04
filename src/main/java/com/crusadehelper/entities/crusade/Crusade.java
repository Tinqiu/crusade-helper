package com.crusadehelper.entities.crusade;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(notes = "The auto-generated Id of the Crusade")
    private int id;

    @OneToMany(mappedBy = "crusade", cascade = CascadeType.ALL)
    @JsonManagedReference
    @Setter(AccessLevel.NONE)
    @ApiModelProperty(notes = "The crusade forces that are participating in this Crusade")
    private List<CrusadeForce> crusadeForces = new ArrayList<>();

    public void addCrusadeForce(CrusadeForce crusadeForce) {
        crusadeForce.setCrusade(this);
        crusadeForces.add(crusadeForce);
    }
}
