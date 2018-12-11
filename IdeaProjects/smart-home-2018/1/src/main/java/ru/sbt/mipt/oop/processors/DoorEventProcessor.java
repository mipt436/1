package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.homeComponents.SmartHome;
import ru.sbt.mipt.oop.homeComponents.Door;

import static ru.sbt.mipt.oop.event.SensorEventType.DOOR_CLOSE;
import static ru.sbt.mipt.oop.event.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {

    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isDoorEvent(event)) return;

        smartHome.executeAction(object -> {
            if (object instanceof Door) {
                Door door = (Door) object;
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        changeDoorState(door, true, " was opened.");
                    } else {
                        changeDoorState(door, false, " was closed.");

                    }
                }
            }
        });
    }


    private void changeDoorState(Door door, boolean opened, String text) {
        door.setOpen(opened);
        System.out.println("Door " + door.getId() + " " + text);
    }

    private boolean isDoorEvent(SensorEvent event) {
        return event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSE;
    }
}