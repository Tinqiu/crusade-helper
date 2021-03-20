package com.crusadehelper.controllers;

import com.crusadehelper.services.CrusadeForceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrusadeForceController {
    private final CrusadeForceService service;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public CrusadeForceController(CrusadeForceService service) {
        this.service = service;
    }

    @GetMapping("/crusadeforce/api/get")
    public ResponseEntity<String> getCrusadeForce(@RequestParam int crusadeId) throws JsonProcessingException {
        var cf = service.getCrusadeForceById(crusadeId);
        if(cf.isPresent())
            return ResponseEntity.ok(objectMapper.writeValueAsString(cf.get()));
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/crusadeforce/api/create")
    public ResponseEntity<String> createCrusadeForce() {
        var cf = service.createCrusadeForce();
        return ResponseEntity.ok("Create new crusade force with id: " + cf.getId());
    }
}
