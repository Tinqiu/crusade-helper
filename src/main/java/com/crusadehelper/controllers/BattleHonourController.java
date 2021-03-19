package com.crusadehelper.controllers;

import com.crusadehelper.services.BattleHonoursService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BattleHonourController {
    private final BattleHonoursService battleHonoursService;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public BattleHonourController(BattleHonoursService battleHonoursService) {
        this.battleHonoursService = battleHonoursService;
    }

    @GetMapping(value = "/battletraits/get")
    public ResponseEntity<String> getBattleTraitsByUnitType(@RequestParam String unitType) throws JsonProcessingException {
        var bt = battleHonoursService.getBattleTraitByUnitType(unitType);
        var json = objectMapper.writeValueAsString(bt);
        return ResponseEntity.ok(json);
    }

    @GetMapping(value = "/battletraits/getAll")
    public ResponseEntity<String> getAllBattleTraits() throws JsonProcessingException {
        var bt = battleHonoursService.getAllBattleTraits();
        var json = objectMapper.writeValueAsString(bt);
        return ResponseEntity.ok(json);
    }
}
