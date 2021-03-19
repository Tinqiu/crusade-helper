package com.crusadehelper.entities.battlehonours.battletraits;

import com.crusadehelper.enums.unittype.UnitType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHARACTER")
public class CharacterBattleTrait extends BattleTrait{
    public CharacterBattleTrait(){
        super(UnitType.CHARACTER, "Character battle trait", "dummy value for a character battle trait");
    }
}
