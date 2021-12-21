package com.drpicox.game.testSteps.components.colonizers;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.components.loadables.LoadableTestView;
import com.drpicox.game.testSteps.entities.EntityTestView;
import com.drpicox.game.testSteps.entities.PrettyKey;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

@Component
public class ColonizeCurrentRegionStep extends AbstractPostLineStep {

    private final EntityTestView entityTestView;

    public ColonizeCurrentRegionStep(EntityTestView entityTestView) {
        this.entityTestView = entityTestView;
    }

    @Override
    protected String getRegex() {
        return "Colonize current region";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var entiyId = entityTestView.getEntityId();

        entityTestView.post("colonizers", "colonize");
    }
}
