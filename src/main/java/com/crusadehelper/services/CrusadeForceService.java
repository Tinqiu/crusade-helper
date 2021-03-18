package com.crusadehelper.services;

import com.crusadehelper.entities.CrusadeCard;
import com.crusadehelper.entities.CrusadeForce;
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
        CrusadeCard card = new CrusadeCard();
        cf.addCrusadeCard(card);
        return repository.save(cf);
    }

    public Optional<CrusadeForce> getCrusadeForceById(int id){
        return repository.findById(id);
    }

}
