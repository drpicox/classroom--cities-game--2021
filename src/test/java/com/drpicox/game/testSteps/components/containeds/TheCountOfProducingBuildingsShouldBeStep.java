package com.drpicox.game.testSteps.components.containeds;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class TheCountOfProducingBuildingsShouldBeStep extends AbstractPostLineStep {

    private final ContainerTestView containerTestView;

    public TheCountOfProducingBuildingsShouldBeStep(ContainerTestView containerTestView) {
        this.containerTestView = containerTestView;
    }

    @Override
    protected String getRegex() {
        return "The count of producing buildings should be (\\d+)";
    }

    @Override
    protected void run(PostLine line, String[] match) {}
}
