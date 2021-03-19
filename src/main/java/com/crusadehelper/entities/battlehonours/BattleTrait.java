package com.crusadehelper.entities.battlehonours;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class BattleTrait extends BattleHonour{

    public BattleTrait(){
        super("Battle Trait of Dumminess", "This is a dummy Battle Trait");
    }

    //TODO: add ManyToOne relation with CrusadeCard
}
