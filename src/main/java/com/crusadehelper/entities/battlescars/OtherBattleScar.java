package com.crusadehelper.entities.battlescars;

import com.crusadehelper.enums.unittype.UnitType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("OTHER")
public class OtherBattleScar extends BattleScar{
    public OtherBattleScar(){
        super("OH NO A SCAR", "dummy other battle scar", UnitType.OTHER);
    }
}
