package com.crusadehelper.apiclient.models.requests.battlehonoursapi;

import lombok.Data;

/**
 * POJO class to hold GET request to BattleHonours API BattleTrait endpoint
 */
@Data
public class GetBattleTraitRequest {
    public String unitType;
}
