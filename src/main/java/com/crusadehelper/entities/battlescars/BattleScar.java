package com.crusadehelper.entities.battlescars;

import com.crusadehelper.entities.CrusadeCard;
import com.crusadehelper.enums.unittype.UnitType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity(name = "Battle_Scar")
@Data
@DiscriminatorColumn(name = "Unit_Type")
@ApiModel(description = "A battle scar")
public abstract class BattleScar {

    protected BattleScar(String name, String description, UnitType unitType) {
        this.name = name;
        this.description = description;
        this.unitType = unitType;
    }

    protected BattleScar() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Battle_Scar_Id", columnDefinition = "int", nullable = false)
    private int id;

    @Column(name = "Name", columnDefinition = "nvarchar(255)", nullable = false)
    private String name;

    @Column(name = "Description", columnDefinition = "nvarchar(255)", nullable = false)
    private String description;

    @Column(name = "Unit_Type", columnDefinition = "nvarchar(255)", nullable = false, insertable = false, updatable = false)
    private UnitType unitType;

    @ManyToOne
    @JoinColumn(name = "crusade_card_id", nullable = false)
    @JsonBackReference
    @ToString.Exclude
    private CrusadeCard crusadeCard;


}
