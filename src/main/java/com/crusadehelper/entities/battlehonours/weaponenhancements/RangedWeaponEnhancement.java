package com.crusadehelper.entities.battlehonours.weaponenhancements;

import com.crusadehelper.enums.weapontype.WeaponType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RANGED")
public class RangedWeaponEnhancement extends WeaponEnhancement {

    public RangedWeaponEnhancement(){
        super(WeaponType.RANGED, "Ranged Weapon Enhancement", "dummy value for ranged weapon enhancements");
    }
}
