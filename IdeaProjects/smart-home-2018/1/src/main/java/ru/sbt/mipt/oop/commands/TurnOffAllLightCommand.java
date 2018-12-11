package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.homeComponents.Light;
import ru.sbt.mipt.oop.homeComponents.SmartHome;

public class TurnOffAllLightCommand implements Command {
    final private SmartHome smartHome;

    TurnOffAllLightCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.executeAction(object -> {
            if (object instanceof Light) {
                ((Light) object).setOn(false);
            }
        });
    }
}
