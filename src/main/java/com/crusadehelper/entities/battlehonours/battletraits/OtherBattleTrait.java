package com.crusadehelper.entities.battlehonours.battletraits;

import com.crusadehelper.enums.unittype.UnitType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("OTHER")
public class OtherBattleTrait extends BattleTrait{
    public OtherBattleTrait(){
        super(UnitType.OTHER, "Other battle trait", "dummy value for a other battle trait");
    }
}
