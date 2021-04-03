package com.crusadehelper.web.controllers;

import com.crusadehelper.entities.crusade.Crusade;
import com.crusadehelper.services.CrusadeService;
import com.crusadehelper.web.forms.CrusadeForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/crusade/v1")
@Api(tags = "Crusade")
@Slf4j
public class CrusadeController {
    private final CrusadeService crusadeService;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String UNEXPECTED_ERROR_MSG = "An unexpected error occurred, try creating a crusade again.";

    public CrusadeController(CrusadeService crusadeService) {
        this.crusadeService = crusadeService;
    }


    @PostMapping(value = "/crusade", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Creates a new crusade with a new crusade force for the creating player",
            response = Crusade.class)
    public ResponseEntity<String> createCrusade(@RequestParam String player, @RequestParam String faction) {

        //convert the two values into a form object that the service consumes; sets us up properly for later when we
        //change the input types. Proper input validation to come when input will be switched
        var crusadeForm = new CrusadeForm(player, faction);
        var crusade = crusadeService.createCrusade(crusadeForm);

        try {
            if (crusade.isPresent()) {
                //TODO: change this for a 201 - created when ready
                return ResponseEntity.ok(objectMapper.writeValueAsString(crusade.get()));
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(UNEXPECTED_ERROR_MSG);
            }
        } catch (JsonProcessingException ex) {
            log.error("Error writing crusade value: {}, as JSON", crusade, ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(UNEXPECTED_ERROR_MSG);
        }
    }

    @GetMapping("/crusade/dummy")
    @ApiOperation(value = "returns a crusade with the specified id", response = Crusade.class)
    public ResponseEntity<Crusade> getCrusade(@RequestParam int crusadeId) throws JsonProcessingException {
        var crusade = crusadeService.getCrusadeById(crusadeId);
        return crusade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
