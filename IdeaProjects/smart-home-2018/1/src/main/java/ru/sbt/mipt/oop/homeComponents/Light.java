package ru.sbt.mipt.oop.homeComponents;

import ru.sbt.mipt.oop.action.Action;
import ru.sbt.mipt.oop.action.Actionable;

public class Light implements Actionable {
    private boolean isOn;
    private final String id;

    public Light(boolean isOn, String id) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }
}
