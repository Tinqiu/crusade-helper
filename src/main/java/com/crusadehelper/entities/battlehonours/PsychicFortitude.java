package com.crusadehelper.entities.battlehonours;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity(name = "Psychic_Fortitude")
@Data
@EqualsAndHashCode(callSuper = true)
public class PsychicFortitude extends BattleHonour {

    public PsychicFortitude() {
        super("PSYCH_FORT_DUMMY", "Placeholder description for a Psychic Fortitude");
    }

    //TODO: add ManyToOne relation with CrusadeCard
}
