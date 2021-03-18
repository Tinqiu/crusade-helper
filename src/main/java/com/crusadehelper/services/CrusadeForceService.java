package com.crusadehelper.services;

import com.crusadehelper.entities.CrusadeForce;
import com.crusadehelper.repositories.CrusadeForceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrusadeForceService {
    private final CrusadeForceRepository repository;

    public CrusadeForce createCrusadeForce(){
        var cf = new CrusadeForce();
        return repository.save(cf);
    }

}
