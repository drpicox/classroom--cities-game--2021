package com.drpicox.game.testSteps.entities;

import com.drpicox.game.components.locateds.LocatedsController;
import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class GivenThatTheShipLocationIsStep extends AbstractPostLineStep {

    private final EntityTestView entityTestView;
    private final LocatedsController locatedsController;

    public GivenThatTheShipLocationIsStep(EntityTestView entityTestView, LocatedsController locatedsController) {
        this.entityTestView = entityTestView;
        this.locatedsController = locatedsController;
    }

    @Override
    protected String getRegex() {
        return "Given that the ship location is (\\d+)";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var desiredTestLocation = Integer.parseInt(match[1]);
        var entityId = entityTestView.getEntityId();

        locatedsController.changeLocation(entityId, desiredTestLocation);
    }
}
