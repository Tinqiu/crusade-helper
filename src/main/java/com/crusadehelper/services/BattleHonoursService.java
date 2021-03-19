package com.crusadehelper.services;

import com.crusadehelper.entities.battlehonours.battletraits.*;
import com.crusadehelper.enums.unittype.UnitType;
import com.crusadehelper.repositories.BattleTraitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BattleHonoursService {
    private final BattleTraitRepository repository;

    public BattleHonoursService(BattleTraitRepository repository) {
        this.repository = repository;
        repository.save(new CharacterBattleTrait());
        repository.save(new VehicleBattleTrait());
        repository.save(new OtherBattleTrait());
        repository.save(new MonsterBattleTrait());
    }

    public List<BattleTrait> getBattleTraitByUnitType(String param){
        var unitType = UnitType.valueOf(param);
        return repository.findBattleTraitsByUnitType(unitType);
    }

    public List<BattleTrait> getAllBattleTraits(){
        return repository.findAll();
    }


}
