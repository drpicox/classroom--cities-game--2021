package com.drpicox.game.components.colonizer.api;

import com.drpicox.game.components.colonizer.ColonizerController;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.games.api.GamesApi;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/colonizers")
public class ColonizerApi {

    private final ColonizerController colonizerController;
    private final GamesApi gamesApi;

    public ColonizerApi(ColonizerController colonizerController, GamesApi gamesApi) {
        this.colonizerController = colonizerController;
        this.gamesApi = gamesApi;
    }

    @PostMapping("/{entityId}/colonize")
    public GameData load(@PathVariable String entityId, @RequestParam String playerName) {

        colonizerController.colonize(entityId);

        return gamesApi.play(playerName);
    }
}
