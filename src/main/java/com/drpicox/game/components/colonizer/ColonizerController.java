package com.drpicox.game.components.colonizer;

import com.drpicox.game.components.locateds.LocatedsController;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.entities.cities.CityFactory;
import com.drpicox.game.players.PlayersController;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class ColonizerController {

    private final ColonizerRepository colonizerRepository;
    private final PlayersController playersController;
    private final CityFactory cityFactory;
    private final LocatedsController locatedsController;
    private final OwnedsController ownedsController;

    public ColonizerController(ColonizerRepository colonizerRepository, PlayersController playersController, CityFactory cityFactory, LocatedsController locatedsController, OwnedsController ownedsController) {
        this.colonizerRepository = colonizerRepository;
        this.playersController = playersController;
        this.cityFactory = cityFactory;
        this.locatedsController = locatedsController;
        this.ownedsController = ownedsController;
    }

    public Colonizer create(String entityId, String shipId, int colonizedLocation) {
        var component = new Colonizer(entityId, shipId, colonizedLocation);
        colonizerRepository.save(component);
        return component;
    }


    public Player colonize(String entityId) {

        var colonizer = colonizerRepository.findById(entityId).get();
        var shipId = colonizer.getShipId();
        var newColonizedLocation = locatedsController.getLocation(shipId);
        var player = ownedsController.findById(shipId).getOwner();
        colonizer.colonizeLocation(newColonizedLocation);

        var cityId = cityFactory.buildCity(player, "Finisterre", 1);
        locatedsController.changeLocation(cityId, newColonizedLocation);
        colonizerRepository.save(colonizer);

        return player;
    }
}
