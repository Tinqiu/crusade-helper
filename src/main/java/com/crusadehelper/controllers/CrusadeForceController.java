package com.crusadehelper.controllers;

import com.crusadehelper.services.CrusadeForceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrusadeForceController {
    private final CrusadeForceService service;

    public CrusadeForceController(CrusadeForceService service) {
        this.service = service;
    }

    @GetMapping("/crusadeforce/api/get")
    public ResponseEntity<String> getCrusadeForce() {
        return ResponseEntity.ok("Got it!");
    }

    @PostMapping("/crusadeforce/api/create")
    public ResponseEntity<String> createCrusadeForce() {
        var cf = service.createCrusadeForce();
        return ResponseEntity.ok("Create new crusade force with id: " + cf.getId());
    }
}
