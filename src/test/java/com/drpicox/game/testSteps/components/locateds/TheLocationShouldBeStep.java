package com.drpicox.game.testSteps.components.locateds;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.entities.EntityResponse;
import com.drpicox.game.testSteps.entities.EntityTestView;
import com.drpicox.game.testSteps.entities.PrettyKey;
import com.drpicox.game.testSteps.game.GameTestView;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheLocationShouldBeStep extends AbstractPostLineStep {

    private final EntityTestView entityTestView;

    public TheLocationShouldBeStep(EntityTestView entityTestView) {
        this.entityTestView = entityTestView;
    }

    @Override
    protected String getRegex() {
        return "The location should be (\\d+)";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var expectedValue = PrettyKey.getKey(match[1]);

        var value = entityTestView.getEntity().get("location", String.class);
        assertThat(String.valueOf(value)).isEqualTo(expectedValue);
    }
}
