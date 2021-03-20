package com.crusadehelper.entities.battlehonours.weaponenhancements;

import com.crusadehelper.enums.weapontype.WeaponType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MELEE")
public class MeleeWeaponEnhancement extends WeaponEnhancement {

    public MeleeWeaponEnhancement(){
        super(WeaponType.MELEE, "Melee Weapon Enhancement", "dummy value for melee weapon enhancements");
    }
}
