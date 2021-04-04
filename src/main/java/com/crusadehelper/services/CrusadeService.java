package com.crusadehelper.services;

import com.crusadehelper.entities.crusade.Crusade;
import com.crusadehelper.entities.crusade.CrusadeForce;
import com.crusadehelper.enums.faction.Faction;
import com.crusadehelper.repositories.crusade.CrusadeRepository;
import com.crusadehelper.web.forms.CrusadeForm;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class CrusadeService {
    private final CrusadeRepository crusadeRepository;
    private final CrusadeForceService crusadeForceService;

    public CrusadeService(CrusadeRepository crusadeRepository, CrusadeForceService crusadeForceService) {
        this.crusadeRepository = crusadeRepository;
        this.crusadeForceService = crusadeForceService;
    }

    /**
     * Creates a new crusade. The player that created the crusade is automatically added to it with a blank
     * {@link CrusadeForce} with the provided {@link Faction}.
     *
     * @param crusadeForm the form containing the information necessary to create a crusade
     * @return the created Crusade
     */
    public Optional<Crusade> createCrusade(@NonNull CrusadeForm crusadeForm) {
        //TODO: change the initialPlayer type to a User entity when ready
        Crusade crusade = new Crusade();
        try {
            var crusadeForce = createInitialPlayerCrusadeForce(crusadeForm);
            crusade.addCrusadeForce(crusadeForce);
        } catch (IllegalArgumentException ex) {
            return Optional.empty();
        }
        return Optional.of(crusadeRepository.save(crusade));
    }

    /**
     * Creates a {@link CrusadeForce} assigned to the player that is creating the crusade.
     *
     * @param crusadeForm
     * @return a CrusadeForce with the provided {@link Faction} and assigned to the provided player
     */
    private CrusadeForce createInitialPlayerCrusadeForce(CrusadeForm crusadeForm) {
        Faction faction = Faction.fromString(crusadeForm.getFaction());
        String player = crusadeForm.getPlayer();
        return crusadeForceService.createCrusadeForce(player, faction);
    }

    public Optional<Crusade> getCrusadeById(int crusadeId) {
        return crusadeRepository.findById(crusadeId);
    }
}
