package ru.sbt.mipt.oop.commands;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.InitTestHome;
import ru.sbt.mipt.oop.homeComponents.SmartHome;
import ru.sbt.mipt.oop.homeComponents.Door;
import ru.sbt.mipt.oop.homeComponents.Room;

import static org.junit.Assert.assertFalse;

public class CloseHallDoorCommandTest {
    private SmartHome smartHome;
    private Command command;

    @Before
    public void init() {
        smartHome = InitTestHome.init();
        command = new CloseHallDoorCommand(smartHome);
    }

    @Test
    public void successTest() {
        command.execute();
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                for (Door door : room.getDoors()) {
                    assertFalse(door.isOpen());
                }
            }
        }
    }
}
