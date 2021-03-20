package com.crusadehelper.entities.battlescars;

import com.crusadehelper.enums.unittype.UnitType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MONSTER")
public class MonsterBattleScar extends BattleScar{
    public MonsterBattleScar(){
        super("Got booped too hard", "dummy monster battle scar", UnitType.MONSTER);
    }
}
