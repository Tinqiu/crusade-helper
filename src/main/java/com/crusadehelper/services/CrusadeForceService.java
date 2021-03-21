package com.crusadehelper.services;

import com.crusadehelper.entities.CombatTally;
import com.crusadehelper.entities.CrusadeCard;
import com.crusadehelper.entities.CrusadeForce;
import com.crusadehelper.entities.battlescars.*;
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

    public CrusadeForce createCrusadeForce() {
        var cf = new CrusadeForce();
        cf.setFaction(Faction.NECRONS);
        cf.setBattleTally(2);
        cf.setVictories(1);
        cf.setName("Silent King 2k");
        cf.setRequisitionPoints(3);
        cf.setSupplyLimit(50);
        cf.setSupplyUsed(43);
        cf.setPlayerName("Vincent");
        CrusadeCard card = createDummyCard();
        cf.addCrusadeCard(card);


        return repository.save(cf);
    }

    public Optional<CrusadeForce> getCrusadeForceById(int id) {
        return repository.findById(id);
    }

    private CrusadeCard createDummyCard() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        var randomUnitType = UnitType.values()[random.nextInt(0,UnitType.values().length)];

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

    private CombatTally createDummyCombatTally(){
        var tally = new CombatTally();
        tally.setUnitsDestroyedMelee(2);
        tally.setUnitsDestroyedPsychic(1);
        log.info("Created combat tally: {}", tally);
        return tally;
    }

    private BattleScar createDummyBattleScar(UnitType unitType){
        switch (unitType){
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
}
