package com.crusadehelper.controllers;

import com.crusadehelper.entities.crusade.Crusade;
import com.crusadehelper.services.CrusadeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/crusade/v1")
@Api(tags = "Crusade")
public class CrusadeController {
    private final CrusadeService crusadeService;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public CrusadeController(CrusadeService crusadeService) {
        this.crusadeService = crusadeService;
    }

    @PostMapping("/crusade/dummy")
    @ApiOperation(value = "Creates a new dummy crusade with 2 forces", response = Crusade.class)
    public ResponseEntity<String> createDummyCrusade() throws JsonProcessingException {
        var crusade = crusadeService.createCrusade();
        return ResponseEntity.ok(objectMapper.writeValueAsString(crusade));
    }

    @GetMapping("/crusade/dummy")
    @ApiOperation(value = "returns a crusade with the specified id", response = Crusade.class)
    public ResponseEntity<String> getCrusade(@RequestParam int crusadeId) throws JsonProcessingException {
        var crusade = crusadeService.getCrusadeById(crusadeId);
        if (crusade.isPresent())
            return ResponseEntity.ok(objectMapper.writeValueAsString(crusade.get()));
        return ResponseEntity.notFound().build();
    }
}
