package com.crusadehelper.repositories;

import com.crusadehelper.entities.battlehonours.battletraits.BattleTrait;
import com.crusadehelper.enums.unittype.UnitType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleTraitRepository extends JpaRepository<BattleTrait, Integer> {

    public BattleTrait findBattleTraitByUnitType(UnitType unitType);
}
