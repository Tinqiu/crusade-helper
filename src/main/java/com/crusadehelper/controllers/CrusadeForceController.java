package com.crusadehelper.controllers;

import com.crusadehelper.entities.CrusadeForce;
import com.crusadehelper.services.CrusadeForceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/CrusadeForce/v1")
@Api(tags="Crusade Force")
public class CrusadeForceController {
    private final CrusadeForceService service;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public CrusadeForceController(CrusadeForceService service) {
        this.service = service;
    }

    @ApiOperation(value = "Retrieve the specified crusade force and its battle cards", response = CrusadeForce.class)
    @GetMapping(value = "/api/CrusadeForce/v1/CrusadeForce", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCrusadeForce(@RequestParam int crusadeId) throws JsonProcessingException {
        var cf = service.getCrusadeForceById(crusadeId);
        if(cf.isPresent())
            return ResponseEntity.ok(objectMapper.writeValueAsString(cf.get()));
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Retrieve all crusade forces and their battle cards", response = CrusadeForce.class)
    @PostMapping(value = "/api/CrusadeForce/v1/CrusadeForce")
    public ResponseEntity<String> createCrusadeForce() {
        var cf = service.createCrusadeForce();
        return ResponseEntity.ok("Create new crusade force with id: " + cf.getId());
    }
}
