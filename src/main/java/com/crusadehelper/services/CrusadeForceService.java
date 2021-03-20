package com.crusadehelper.services;

import com.crusadehelper.entities.CrusadeCard;
import com.crusadehelper.entities.CombatTally;
import com.crusadehelper.entities.CrusadeForce;
import com.crusadehelper.enums.faction.Faction;
import com.crusadehelper.enums.rank.Rank;
import com.crusadehelper.enums.unittype.UnitType;
import com.crusadehelper.repositories.CrusadeForceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CrusadeForceService {
    private final CrusadeForceRepository repository;

    public CrusadeForce createCrusadeForce(){
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
        var cc = new CrusadeCard("CrusadeCardTEST", Faction.AELDARI, UnitType.CHARACTER);
        var ct = new CombatTally();
        ct.setUnitsDestroyedMelee(2);
        ct.setUnitsDestroyedPsychic(1);
        cc.addCombatTally(ct);
        cf.addCrusadeCard(cc);
        return repository.save(cf);
    }

    public Optional<CrusadeForce> getCrusadeForceById(int id){
        return repository.findById(id);
    }

    private CrusadeCard createDummyCard(){
        CrusadeCard card = new CrusadeCard("Test Unit of DOOM", Faction.AELDARI, UnitType.OTHER);
        card.setBattlefieldRole("Bring DOOOOOM");
        card.setCrusadePoints(666);
        card.setRank(Rank.LEGENDARY);

        return card;
    }
}
