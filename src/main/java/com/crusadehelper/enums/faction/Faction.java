package com.crusadehelper.enums.faction;

public enum Faction {
    IMPERIUM,
    CHAOS,
    AELDARI,
    TYRANIDS,
    ORKS,
    NECRONS,
    TAU_EMPIRE;

    /**
     * Provides a casing-agnostic way of converting a String value into a Faction.
     *
     * @param faction the faction name to be converted
     * @return a valid Faction if one is found
     * @throws IllegalArgumentException if the provided value does not match a Faction name
     **/
    public static Faction fromString(String faction) throws IllegalArgumentException {
        for (Faction factionVal : Faction.values()) {
            if (factionVal.name().equalsIgnoreCase(faction))
                return factionVal;
        }
        throw new IllegalArgumentException(String.format("Value %s is not a valid faction", faction));
    }
}
