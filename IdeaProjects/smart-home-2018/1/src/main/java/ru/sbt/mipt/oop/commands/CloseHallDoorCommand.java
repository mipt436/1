package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.homeComponents.Door;
import ru.sbt.mipt.oop.homeComponents.Room;
import ru.sbt.mipt.oop.homeComponents.SmartHome;

public class CloseHallDoorCommand implements Command {
    final private SmartHome smartHome;

    CloseHallDoorCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                room.executeAction(objectDoor -> {
                    if (objectDoor instanceof Door) {
                        ((Door) objectDoor).setOpen(false);
                    }
                });
            }
        }
    }
}
