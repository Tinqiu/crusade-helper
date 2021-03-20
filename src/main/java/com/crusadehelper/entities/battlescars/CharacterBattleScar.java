package com.crusadehelper.entities.battlescars;

import com.crusadehelper.enums.unittype.UnitType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHARACTER")
public class CharacterBattleScar extends BattleScar{
    public CharacterBattleScar(){
        super("Lost an arm", "dummy character battle scar", UnitType.CHARACTER);
    }
}
