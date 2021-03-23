package com.crusadehelper.apiclient;

import com.crusadehelper.apiclient.models.requests.battlehonoursapi.GetBattleTraitRequest;
import com.crusadehelper.apiclient.models.requests.battlehonoursapi.GetBattleTraitsRequest;
import com.crusadehelper.apiclient.models.requests.battlehonoursapi.GetWeaponEnhancementRequest;
import com.crusadehelper.apiclient.models.requests.battlehonoursapi.GetWeaponEnhancementsRequest;
import com.crusadehelper.apiclient.models.requests.crusadeforceapi.GetCrusadeForceRequest;
import com.crusadehelper.apiclient.models.requests.crusadeforceapi.PostCrusadeForceRequest;
import io.swagger.models.Response;
import org.apache.commons.lang3.NotImplementedException;

public class Endpoints {
    public static final String BASE_URL = "http://localhost:8080";

    public static Response authenticateUser() {
        throw new NotImplementedException();
    }
    public static Response getCrusadeForce(GetCrusadeForceRequest crusadeForceRequest) {
        throw new NotImplementedException();
    }
    public static Response addCrusadeForce(PostCrusadeForceRequest crusadeForceRequest) {
        throw new NotImplementedException();
    }
    public static Response getBattleTrait(GetBattleTraitRequest battleTraitRequest) {
        throw new NotImplementedException();
    }
    public static Response getBattleTraits(GetBattleTraitsRequest battleTraitsRequest) {
        throw new NotImplementedException();
    }
    public static Response getWeaponEnhancement(GetWeaponEnhancementRequest weaponEnhancementRequest) {
        throw new NotImplementedException();
    }
    public static Response getWeaponEnhancements(GetWeaponEnhancementsRequest weaponEnhancementsRequest) {
        throw new NotImplementedException();
    }
}
