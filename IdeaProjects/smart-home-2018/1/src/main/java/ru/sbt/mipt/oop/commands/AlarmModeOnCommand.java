package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.homeComponents.SmartHome;

public class AlarmModeOnCommand implements Command {
    final private SmartHome smartHome;

    AlarmModeOnCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.getAlarm().setAlarmMode();
    }
}
