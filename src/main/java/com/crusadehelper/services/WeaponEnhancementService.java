package com.crusadehelper.services;

import com.crusadehelper.entities.battlehonours.weaponenhancements.MeleeWeaponEnhancement;
import com.crusadehelper.entities.battlehonours.weaponenhancements.RangedWeaponEnhancement;
import com.crusadehelper.entities.battlehonours.weaponenhancements.WeaponEnhancement;
import com.crusadehelper.enums.weapontype.WeaponType;
import com.crusadehelper.repositories.battlehonours.WeaponEnhancementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponEnhancementService {
    private final WeaponEnhancementRepository weaponEnhancementRepository;

    public WeaponEnhancementService(WeaponEnhancementRepository weaponEnhancementRepository) {
        this.weaponEnhancementRepository = weaponEnhancementRepository;
        weaponEnhancementRepository.save(new RangedWeaponEnhancement());
        weaponEnhancementRepository.save(new MeleeWeaponEnhancement());
    }

    public List<WeaponEnhancement> getWeaponEnhancementByType(String weaponType) {
        var weaponTypeVal = WeaponType.valueOf(weaponType);
        return weaponEnhancementRepository.findAllByWeaponType(weaponTypeVal);
    }

    public List<WeaponEnhancement> getAllWeaponEnhancements() {
        return weaponEnhancementRepository.findAll();
    }
}
