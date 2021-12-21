package com.drpicox.game.components.colonizer;

import com.drpicox.game.ecs.EntityOwnDataGenerator;
import com.drpicox.game.ecs.EntityVisibleDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ColonizerEntityDataGenerator implements EntityOwnDataGenerator, EntityVisibleDataGenerator {

    private final ColonizerRepository colonizerRepository;

    public ColonizerEntityDataGenerator(ColonizerRepository colonizerRepository) {
        this.colonizerRepository = colonizerRepository;
    }

    @Override
    public void generateOwnData(GameData data, Player playingPlayer, List<String> entityIds) {
        generateData(data, entityIds);
    }

    @Override
    public void generateVisibleData(GameData data, Player playingPlayer, List<String> entityIds) {
        generateData(data, entityIds);
    }

    public void generateData(GameData data, List<String> entityIds) {
        var components = colonizerRepository.findAllById(entityIds);
        for (Colonizer component : components) {
            var entityId = component.getEntityId();
            data.putEntityProperty(entityId, "colonizable", true);
            data.putEntityProperty(entityId, "shipId", component.getEntityId());
        }
    }
}
