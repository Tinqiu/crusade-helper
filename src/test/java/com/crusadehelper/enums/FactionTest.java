package com.crusadehelper.enums;

import com.crusadehelper.enums.faction.Faction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactionTest {

    @Test
    void shouldCreateFactionFromStringSuccessfully() {
        String inputVal = "necrons";
        Faction expected = Faction.NECRONS;

        Faction result = Faction.fromString(inputVal);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldThrowIllegalArgumentException() {
        String inputVal = "blargh";
        Class<IllegalArgumentException> expected = IllegalArgumentException.class;

        Assertions.assertThrows(expected, () -> Faction.fromString(inputVal));
    }
}
