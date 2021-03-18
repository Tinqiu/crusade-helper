package com.crusadehelper.services;

import com.crusadehelper.entities.CrusadeForce;
import com.crusadehelper.enums.faction.Faction;
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
        return repository.save(cf);
    }

    public Optional<CrusadeForce> getCrusadeForceById(int id){
        return repository.findById(id);
    }

}
