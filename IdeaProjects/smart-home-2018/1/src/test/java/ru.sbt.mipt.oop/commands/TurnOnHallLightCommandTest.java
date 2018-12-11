package ru.sbt.mipt.oop.commands;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.InitTestHome;
import ru.sbt.mipt.oop.homeComponents.SmartHome;
import ru.sbt.mipt.oop.homeComponents.Light;
import ru.sbt.mipt.oop.homeComponents.Room;

import static org.junit.Assert.assertTrue;

public class TurnOnHallLightCommandTest {
    private SmartHome smartHome;
    private Command command;

    @Before
    public void init() {
        smartHome = InitTestHome.init();
        command = new TurnOnHallLightCommand(smartHome);
    }

    @Test
    public void successTest() {
        command.execute();
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                for (Light light : room.getLights()) {
                    assertTrue(light.isOn());
                }
            }
        }
    }
}
