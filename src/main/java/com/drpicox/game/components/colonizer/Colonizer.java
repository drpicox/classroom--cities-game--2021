package com.drpicox.game.components.colonizer;

import com.drpicox.game.ecs.EcsComponent;

import javax.persistence.Entity;

@Entity
public class Colonizer extends EcsComponent {
    private int colonizedLocation;
    private String shipId;

    public Colonizer(String entityId, String shipId, int colonizedLocation) {
        super(entityId);
        this.shipId = shipId;
        this.colonizedLocation = colonizedLocation;
    }

    protected Colonizer() {
    }

    public String getShipId(){
        return this.shipId;
    }
    void colonizeLocation(int newColonizedLocation) {
        this.colonizedLocation = newColonizedLocation;
    }
}


