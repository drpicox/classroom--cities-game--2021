package com.drpicox.game.testSteps.components.containeds;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth8.assertThat;

@Component
public class ThereShouldNotContainTheStep extends AbstractPostLineStep {

    private final ContainerTestView containerTestView;

    public ThereShouldNotContainTheStep(ContainerTestView containerTestView) {
        this.containerTestView = containerTestView;
    }

    @Override
    protected String getRegex() {
        return "There should not contain the \"([^\"]+)\" \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var type = match[1];
        var name = match[2];

        var contained = containerTestView.findContained(type, name);
        assertThat(contained).isEmpty();
    }
}
