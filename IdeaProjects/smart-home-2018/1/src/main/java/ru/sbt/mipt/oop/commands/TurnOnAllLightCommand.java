package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.homeComponents.Light;
import ru.sbt.mipt.oop.homeComponents.SmartHome;

public class TurnOnAllLightCommand implements Command {
    final private SmartHome smartHome;

    TurnOnAllLightCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.executeAction(object -> {
            if (object instanceof Light) {
                ((Light) object).setOn(true);
            }
        });
    }
}