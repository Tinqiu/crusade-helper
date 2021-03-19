package com.crusadehelper.entities.battlehonours.battletraits;

import com.crusadehelper.enums.unittype.UnitType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VEHICLE")
public class VehicleBattleTrait extends BattleTrait{
    public VehicleBattleTrait(){
        super(UnitType.CHARACTER, "Vehicle battle trait", "dummy value for a vehicle battle trait");
    }
}
