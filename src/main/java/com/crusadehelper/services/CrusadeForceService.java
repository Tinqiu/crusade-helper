package com.crusadehelper.services;

import com.crusadehelper.entities.CrusadeCard;
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
        CrusadeCard card = createDummyCard();
        cf.addCrusadeCard(card);
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
