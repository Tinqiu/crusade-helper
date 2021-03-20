package com.crusadehelper.entities.battlehonours;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public abstract class BattleHonour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    protected BattleHonour(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @ApiModelProperty(notes = "The name of the battle honour")
    private String name;
    @ApiModelProperty(notes = "The description of the battle honour")
    private String description;
}
