package com.crusadehelper.entities.battlehonours;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class WeaponEnhancement extends BattleHonour {

    public WeaponEnhancement() {
        super("MEGA WEAPON", "Dummy entry for Weapon Enhancement");
    }
    //TODO: add ManyToOne relation with CrusadeCard
}
