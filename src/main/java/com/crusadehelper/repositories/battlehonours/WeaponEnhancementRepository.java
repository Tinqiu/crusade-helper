package com.crusadehelper.repositories.battlehonours;

import com.crusadehelper.entities.battlehonours.weaponenhancements.WeaponEnhancement;
import com.crusadehelper.enums.weapontype.WeaponType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeaponEnhancementRepository extends JpaRepository<WeaponEnhancement, Integer> {

    List<WeaponEnhancement> findAllByWeaponType(WeaponType weaponType);
}
