package com.crusadehelper.web.controllers;

import com.crusadehelper.entities.crusade.Crusade;
import com.crusadehelper.entities.crusade.CrusadeForce;
import com.crusadehelper.enums.faction.Faction;
import com.crusadehelper.services.CrusadeService;
import com.crusadehelper.web.forms.CrusadeForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CrusadeControllerTest {
    private CrusadeService crusadeService;
    private CrusadeController crusadeController;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        crusadeService = mock(CrusadeService.class);
        crusadeController = new CrusadeController(crusadeService);
    }

    @Test
    void shouldReturnOkStatusAndValidCrusade() throws JsonProcessingException {
        //inputs
        String playerName = "player1";
        String factionName = Faction.IMPERIUM.name();
        CrusadeForm form = new CrusadeForm(playerName, factionName);

        //expected results
        Faction faction = Faction.IMPERIUM;
        HttpStatus expectedStatus = HttpStatus.OK;
        Crusade expectedCrusade = new Crusade();
        expectedCrusade.addCrusadeForce(new CrusadeForce(playerName, faction));

        //setup mocks and tested objects
        when(crusadeService.createCrusade(form)).thenReturn(Optional.of(expectedCrusade));


        //test
        var response = crusadeController.createCrusade(playerName, factionName);
        var crusade = objectMapper.readValue(response.getBody(), Crusade.class);

        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedStatus, response.getStatusCode()),
                () -> Assertions.assertEquals(expectedCrusade, crusade)
        );
    }

    @Test
    void shouldReturnBadRequestDueToNullForm() {
        Assertions.assertThrows(NullPointerException.class, () -> crusadeController.createCrusade(null, null));
    }

    @Test
    void shouldReturnBadRequestDueToInvalidPlayerName() {
        String playerName = "";
        String factionName = Faction.ORKS.name();
        var response = crusadeController.createCrusade(playerName, factionName);
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
