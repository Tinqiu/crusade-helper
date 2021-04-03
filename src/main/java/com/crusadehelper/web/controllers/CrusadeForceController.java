package com.crusadehelper.web.controllers;

import com.crusadehelper.entities.crusade.CrusadeForce;
import com.crusadehelper.services.CrusadeForceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/CrusadeForce/v1")
@Api(tags = "Crusade Force")
public class CrusadeForceController {
    private final CrusadeForceService service;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public CrusadeForceController(CrusadeForceService service) {
        this.service = service;
    }

    @ApiOperation(value = "Retrieve the specified crusade force and its battle cards", response = CrusadeForce.class)
    @GetMapping(value = "/CrusadeForce", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCrusadeForce(@RequestParam int crusadeForceId) throws JsonProcessingException {
        var cf = service.getCrusadeForceById(crusadeForceId);
        if (cf.isPresent())
            return ResponseEntity.ok(objectMapper.writeValueAsString(cf.get()));
        return ResponseEntity.notFound().build();
    }

//    @ApiOperation(value = "Retrieve all crusade forces and their battle cards", response = CrusadeForce.class)
//    @PostMapping(value = "/CrusadeForce")
//    public ResponseEntity<String> createCrusadeForce() throws JsonProcessingException {
//        var cf = service.createCrusadeForce();
//        return ResponseEntity.ok(objectMapper.writeValueAsString(cf));
//    }
}
