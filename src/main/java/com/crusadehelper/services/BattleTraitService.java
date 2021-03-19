package com.crusadehelper.services;

import com.crusadehelper.entities.battlehonours.battletraits.*;
import com.crusadehelper.enums.unittype.UnitType;
import com.crusadehelper.repositories.BattleTraitRepository;
import org.springframework.stereotype.Service;

@Service
public class BattleTraitService {
    private final BattleTraitRepository repository;

    public BattleTraitService(BattleTraitRepository repository) {
        this.repository = repository;
        repository.save(new CharacterBattleTrait());
        repository.save(new VehicleBattleTrait());
        repository.save(new OtherBattleTrait());
        repository.save(new MonsterBattleTrait());
    }

    public BattleTrait getBattleTraitByUnitType(String param){
        var unitType = UnitType.valueOf(param);
        return repository.findBattleTraitByUnitType(unitType);
    }


}
