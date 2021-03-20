package com.crusadehelper.controllers;

import com.crusadehelper.services.BattleTraitService;
import com.crusadehelper.services.WeaponEnhancementService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BattleHonoursController {
    private final BattleTraitService battleTraitService;
    private final WeaponEnhancementService weaponEnhancementService;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public BattleHonoursController(BattleTraitService battleTraitService,
                                   WeaponEnhancementService weaponEnhancementService) {
        this.battleTraitService = battleTraitService;
        this.weaponEnhancementService = weaponEnhancementService;
    }

    @GetMapping(value = "/api/BattleHonours/v1/BattleTrait")
    public ResponseEntity<String> getBattleTraitsByUnitType(@RequestParam String unitType) throws JsonProcessingException {
        var bt = battleTraitService.getBattleTraitByUnitType(unitType);
        var json = objectMapper.writeValueAsString(bt);
        return ResponseEntity.ok(json);
    }

    @GetMapping(value = "/api/BattleHonours/v1/BattleTraits")
    public ResponseEntity<String> getAllBattleTraits() throws JsonProcessingException {
        var bt = battleTraitService.getAllBattleTraits();
        var json = objectMapper.writeValueAsString(bt);
        return ResponseEntity.ok(json);
    }

    @GetMapping("/api/BattleHonours/v1/WeaponEnhancement")
    public ResponseEntity<String> getAllWeaponEnhancementByType(@RequestParam String type) throws JsonProcessingException {
        var enhancements = weaponEnhancementService.getWeaponEnhancementByType(type);
        var json = objectMapper.writeValueAsString(enhancements);
        return ResponseEntity.ok(json);
    }

    @GetMapping("/api/BattleHonours/v1/WeaponEnhancements")
    public ResponseEntity<String> getAllWeaponEnhancements() throws JsonProcessingException {
        var enhancements = weaponEnhancementService.getAllWeaponEnhancements();
        var json = objectMapper.writeValueAsString(enhancements);
        return ResponseEntity.ok(json);
    }
}
