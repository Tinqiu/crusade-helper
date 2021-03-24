package com.crusadehelper.services;

import com.crusadehelper.entities.crusade.Crusade;
import com.crusadehelper.repositories.crusade.CrusadeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class CrusadeService {
    private final CrusadeRepository crusadeRepository;
    private final CrusadeForceService crusadeForceService;

    public CrusadeService(CrusadeRepository crusadeRepository, CrusadeForceService crusadeForceService) {
        this.crusadeRepository = crusadeRepository;
        this.crusadeForceService = crusadeForceService;
    }

    public Crusade createCrusade(){
        var crusade = new Crusade();
        var crusadeForce1 = crusadeForceService.createCrusadeForce();
        var crusadeForce2 = crusadeForceService.createCrusadeForce();
        crusade.addCrusadeForce(crusadeForce1);
        crusade.addCrusadeForce(crusadeForce2);
        log.info("Created Crusade: {}", crusade);
        return crusadeRepository.save(crusade);
    }

    public Optional<Crusade> getCrusadeById(int crusadeId) {
        return crusadeRepository.findById(crusadeId);
    }
}
