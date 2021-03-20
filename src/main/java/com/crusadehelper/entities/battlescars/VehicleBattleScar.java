package com.crusadehelper.entities.battlescars;

import com.crusadehelper.enums.unittype.UnitType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VEHICLE")
public class VehicleBattleScar extends BattleScar {
    public VehicleBattleScar() {
        super("Popped Tire", "dummy vehicle battle scar", UnitType.VEHICLE);
    }
}
