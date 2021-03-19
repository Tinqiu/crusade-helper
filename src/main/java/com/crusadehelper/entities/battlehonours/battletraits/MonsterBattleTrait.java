package com.crusadehelper.entities.battlehonours.battletraits;

import com.crusadehelper.enums.unittype.UnitType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MONSTER")
public class MonsterBattleTrait extends BattleTrait{
    public MonsterBattleTrait(){
        super(UnitType.CHARACTER, "Monster battle trait", "dummy value for a monster battle trait");
    }
}
