package com.crusadehelper.entities.battlehonours.battletraits;

import com.crusadehelper.entities.battlehonours.BattleHonour;
import com.crusadehelper.enums.unittype.UnitType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorColumn(name = "Unit_Type")
public class BattleTrait extends BattleHonour {


    protected BattleTrait() {
        super("Battle Trait of Dumminess", "This is a dummy Battle Trait");
    }

    protected BattleTrait(UnitType unitType, String name, String desc) {
        super(name, desc);
        this.unitType = unitType;
    }

    //TODO: add ManyToMany relation with CrusadeCard

    @Column(name = "Unit_Type", columnDefinition = "nvarchar(255)", insertable = false, updatable = false)
    private UnitType unitType;
}
