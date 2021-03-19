package com.crusadehelper.entities.battlehonours.weaponenhancements;

import com.crusadehelper.entities.battlehonours.BattleHonour;
import com.crusadehelper.enums.weapontype.WeaponType;
import lombok.Data;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@DiscriminatorColumn(name = "Weapon_Type")
@EqualsAndHashCode(callSuper = true)
public abstract class WeaponEnhancement extends BattleHonour {


    @Column(name = "Weapon_Type", columnDefinition = "nvarchar(255)", insertable = false, updatable = false)
    private WeaponType weaponType;

    //TODO: add ManyToOne relation with CrusadeCard

    protected WeaponEnhancement() {
        super("Dummy weapon enhancement", "this is a dummy weapon enhancement");
    }

    protected WeaponEnhancement(WeaponType weaponType, String name, String description) {
        super(name, description);
        this.weaponType = weaponType;
    }

}


