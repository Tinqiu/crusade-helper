package com.crusadehelper.apiclient;

/**
 * Helper class to retrieve API routes for each endpoint
 */
public class Route {
    private static final String BATTLE_HONOURS_VERSION = "v1";
    private static final String BATTLE_HONOURS = "/BattleHonours/" + BATTLE_HONOURS_VERSION + "/api";
    private static final String CRUSADE_FORCE_VERSION = "v1";
    private static final String CRUSADE_FORCE = "/CrusadeForce/" + CRUSADE_FORCE_VERSION + "/api";

    public static String battleTrait() {
        return BATTLE_HONOURS + "/BattleTrait";
    }
    public static String battleTraits() {
        return BATTLE_HONOURS + "/BattleTraits";
    }
    public static String weaponEnhancement() {
        return BATTLE_HONOURS + "/WeaponEnhancement";
    }
    public static String weaponEnhancements() {
        return BATTLE_HONOURS + "/WeaponEnhancements";
    }
    public static String crusadeForce() {
        return CRUSADE_FORCE + "/CrusadeForce";
    }
}
