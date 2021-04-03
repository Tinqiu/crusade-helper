package com.crusadehelper.services;

import com.crusadehelper.entities.battlescars.*;
import com.crusadehelper.entities.crusade.CombatTally;
import com.crusadehelper.entities.crusade.CrusadeCard;
import com.crusadehelper.entities.crusade.CrusadeForce;
import com.crusadehelper.enums.faction.Faction;
import com.crusadehelper.enums.rank.Rank;
import com.crusadehelper.enums.unittype.UnitType;
import com.crusadehelper.repositories.crusade.CrusadeForceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
@Slf4j
public class CrusadeForceService {
    private final CrusadeForceRepository repository;

    public Optional<CrusadeForce> getCrusadeForceById(int id) {
        return repository.findById(id);
    }

    private CrusadeCard createDummyCard() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        var randomUnitType = UnitType.values()[random.nextInt(0, UnitType.values().length)];

        CrusadeCard card = new CrusadeCard("Test Unit of DOOM", Faction.AELDARI, randomUnitType);
        card.setBattlefieldRole("Bring DOOOOOM");
        card.setCrusadePoints(666);
        card.setRank(Rank.LEGENDARY);
        var tally = createDummyCombatTally();
        var scar = createDummyBattleScar(randomUnitType);
        card.addCombatTally(tally);
        card.addBattleScar(scar);
        log.info("Created combat card: {}", card);
        return card;
    }

    private CombatTally createDummyCombatTally() {
        var tally = new CombatTally();
        tally.setUnitsDestroyedMelee(2);
        tally.setUnitsDestroyedPsychic(1);
        log.info("Created combat tally: {}", tally);
        return tally;
    }

    private BattleScar createDummyBattleScar(UnitType unitType) {
        switch (unitType) {
            case CHARACTER:
                log.info("Creating CHARACTER battle scar");
                return new CharacterBattleScar();
            case MONSTER:
                log.info("Creating MONSTER battle scar");
                return new MonsterBattleScar();
            case VEHICLE:
                log.info("Creating VEHICLE battle scar");
                return new VehicleBattleScar();
            default:
                log.info("Creating OTHER battle scar");
                return new OtherBattleScar();
        }
    }

    CrusadeForce createCrusadeForce(String player, Faction faction) {
        //TODO: add input validation
        return new CrusadeForce(player, faction);
    }
}
