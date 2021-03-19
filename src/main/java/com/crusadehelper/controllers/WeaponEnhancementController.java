package com.crusadehelper.controllers;

import com.crusadehelper.services.WeaponEnhancementService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeaponEnhancementController {
    private final WeaponEnhancementService weaponEnhancementService;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public WeaponEnhancementController(WeaponEnhancementService weaponEnhancementService) {
        this.weaponEnhancementService = weaponEnhancementService;
    }

    @GetMapping("/weaponEnhance/getByType")
    public ResponseEntity<String> getAllWeaponEnhancementByType(@RequestParam String type) throws JsonProcessingException {
        var enhancements = weaponEnhancementService.getWeaponEnhancementByType(type);
        var json = objectMapper.writeValueAsString(enhancements);
        return ResponseEntity.ok(json);
    }

    @GetMapping("/weaponEnhance/getAll")
    public ResponseEntity<String> getAllWeaponEnhancements() throws JsonProcessingException {
        var enhancements = weaponEnhancementService.getAllWeaponEnhancements();
        var json = objectMapper.writeValueAsString(enhancements);
        return ResponseEntity.ok(json);
    }

}
