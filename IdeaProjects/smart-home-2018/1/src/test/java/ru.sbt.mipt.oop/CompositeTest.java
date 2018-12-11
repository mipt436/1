package ru.sbt.mipt.oop;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.homeComponents.Door;
import ru.sbt.mipt.oop.homeComponents.Light;
import ru.sbt.mipt.oop.homeComponents.Room;
import ru.sbt.mipt.oop.homeComponents.SmartHome;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CompositeTest {
    private SmartHome smartHome;

    @Before
    public void init() {
        List<Light> lights;
        List<Door> doors;
        List<Room> rooms = new ArrayList<>();
        //First room
        lights = new ArrayList<>();
        doors = new ArrayList<>();
        lights.add(new Light(true, "1"));
        lights.add(new Light(false, "2"));
        doors.add(new Door(true, "1"));
        doors.add(new Door(false, "2"));
        rooms.add(new Room(lights, doors, "hall"));

        //Second room
        lights = new ArrayList<>();
        doors = new ArrayList<>();
        lights.add(new Light(true, "3"));
        lights.add(new Light(false, "4"));
        doors.add(new Door(true, "3"));
        doors.add(new Door(false, "4"));
        rooms.add(new Room(lights, doors, "kitchen"));
        smartHome = new SmartHome(rooms);
    }

    @Test
    public void closeAllDoors() {
        smartHome.executeAction(object -> {
            if (object instanceof Door) ((Door) object).setOpen(false);
        });
        Collection<Room> rooms = smartHome.getRooms();
        for (Room room : rooms) {
            for (Door door : room.getDoors()) {
                assertFalse(door.isOpen());
            }
        }
    }

    @Test
    public void openAllDoors() {
        smartHome.executeAction(object -> {
            if (object instanceof Door) ((Door) object).setOpen(true);
        });
        Collection<Room> rooms = smartHome.getRooms();
        for (Room room : rooms) {
            for (Door door : room.getDoors()) {
                assertTrue(door.isOpen());
            }
        }
    }
}
