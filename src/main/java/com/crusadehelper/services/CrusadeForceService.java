package com.crusadehelper.services;

import com.crusadehelper.entities.crusade.CrusadeForce;
import com.crusadehelper.enums.faction.Faction;
import com.crusadehelper.repositories.crusade.CrusadeForceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CrusadeForceService {
    private final CrusadeForceRepository repository;

    public Optional<CrusadeForce> getCrusadeForceById(int id) {
        return repository.findById(id);
    }

    CrusadeForce createCrusadeForce(String player, Faction faction) {
        //TODO: add input validation
        return new CrusadeForce(player, faction);
    }
}
