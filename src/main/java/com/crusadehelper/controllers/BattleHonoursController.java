package com.crusadehelper.controllers;

import com.crusadehelper.entities.battlehonours.battletraits.BattleTrait;
import com.crusadehelper.entities.battlehonours.weaponenhancements.WeaponEnhancement;
import com.crusadehelper.services.BattleTraitService;
import com.crusadehelper.services.WeaponEnhancementService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/BattleHonours/v1")
@Api(tags="Battle Honours")
public class BattleHonoursController {
    private final BattleTraitService battleTraitService;
    private final WeaponEnhancementService weaponEnhancementService;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public BattleHonoursController(BattleTraitService battleTraitService,
                                   WeaponEnhancementService weaponEnhancementService) {
        this.battleTraitService = battleTraitService;
        this.weaponEnhancementService = weaponEnhancementService;
    }

    @ApiOperation(value = "Retrieve battle traits for the specified unit type", response = BattleTrait.class)
    @GetMapping(value = "/BattleTrait", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getBattleTraitsByUnitType(@RequestParam String unitType) throws JsonProcessingException {
        var bt = battleTraitService.getBattleTraitByUnitType(unitType);
        var json = objectMapper.writeValueAsString(bt);
        return ResponseEntity.ok(json);
    }

    @ApiOperation(value = "Retrieve all battle traits for all unit types", response = BattleTrait.class)
    @GetMapping(value = "/BattleTraits", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllBattleTraits() throws JsonProcessingException {
        var bt = battleTraitService.getAllBattleTraits();
        var json = objectMapper.writeValueAsString(bt);
        return ResponseEntity.ok(json);
    }

    @ApiOperation(value = "Retrieve weapon enhancements for the specified weapon type", response = WeaponEnhancement.class)
    @GetMapping(value = "/WeaponEnhancement", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllWeaponEnhancementByType(@RequestParam String type) throws JsonProcessingException {
        var enhancements = weaponEnhancementService.getWeaponEnhancementByType(type);
        var json = objectMapper.writeValueAsString(enhancements);
        return ResponseEntity.ok(json);
    }

    @ApiOperation(value = "Retrieve all weapon enhancements for all weapon types", response = WeaponEnhancement.class)
    @GetMapping(value = "/WeaponEnhancements", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllWeaponEnhancements() throws JsonProcessingException {
        var enhancements = weaponEnhancementService.getAllWeaponEnhancements();
        var json = objectMapper.writeValueAsString(enhancements);
        return ResponseEntity.ok(json);
    }
}
