package com.crusadehelper.controllers;

import com.crusadehelper.services.CrusadeForceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
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

    @GetMapping(value = "/api/CrusadeForce/v1/CrusadeForce", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCrusadeForce(@RequestParam int crusadeForceId) throws JsonProcessingException {
        var cf = service.getCrusadeForceById(crusadeForceId);
        if(cf.isPresent())
            return ResponseEntity.ok(objectMapper.writeValueAsString(cf.get()));
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/api/CrusadeForce/v1/CrusadeForce")
    public ResponseEntity<String> createCrusadeForce() {
        var cf = service.createCrusadeForce();
        return ResponseEntity.ok("Create new crusade force with id: " + cf.getId());
    }
}
