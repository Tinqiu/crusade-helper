package com.crusadehelper.enums;

import com.crusadehelper.enums.faction.Faction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

class FactionTest {

    private static Stream<Arguments> validValuesForFromString(){
        return Stream.of(
                Arguments.of("iMperIuM", Faction.IMPERIUM),
                Arguments.of("CHaOS", Faction.CHAOS),
                Arguments.of("AelDARI", Faction.AELDARI),
                Arguments.of("TYranIdS", Faction.TYRANIDS),
                Arguments.of("ORkS", Faction.ORKS),
                Arguments.of("necrons", Faction.NECRONS),
                Arguments.of("TAU_EMPIRE", Faction.TAU_EMPIRE)
        );
    }

    @ParameterizedTest
    @DisplayName("Provide valid inputs")
    @MethodSource("validValuesForFromString")
    void shouldCreateFactionFromStringSuccessfully(String input, Faction expected) {

        Faction result = Faction.fromString(input);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Attempt to pass an invalid faction name")
    void shouldNotAcceptAnInvalidFactionName() {
        String inputVal = "blargh";
        Class<IllegalArgumentException> expected = IllegalArgumentException.class;

        Assertions.assertThrows(expected, () -> Faction.fromString(inputVal));
    }

    @ParameterizedTest
    @DisplayName("Attempt to pass a null value")
    @NullAndEmptySource
    void shouldNotAcceptNullAndEmptyValue(String input){
        Assertions.assertThrows(IllegalArgumentException.class, () -> Faction.fromString(input));
    }
}
