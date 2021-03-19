package com.crusadehelper.entities.battlehonours;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Relic extends BattleHonour {

    public Relic(){
        super("RELIC OF POWAH", "Dummy relic");
    }

    //TODO: add ManyToOne relation with CrusadeCard
}
