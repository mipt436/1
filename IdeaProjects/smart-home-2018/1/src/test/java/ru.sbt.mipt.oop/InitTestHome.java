package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.homeComponents.Door;
import ru.sbt.mipt.oop.homeComponents.Light;
import ru.sbt.mipt.oop.homeComponents.Room;
import ru.sbt.mipt.oop.homeComponents.SmartHome;

import java.util.ArrayList;
import java.util.List;

public class InitTestHome {
    public static SmartHome init(String name1, String name2) {
        List<Door> doors = new ArrayList<>();
        doors.add(new Door(true, "1"));
        doors.add(new Door(false, "2"));
        List<Light> lights = new ArrayList<>();
        lights.add(new Light(true, "1"));
        lights.add(new Light(false, "2"));
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(lights, doors, name1));
        rooms.add(new Room(lights, doors, name2));
        return new SmartHome(rooms);
    }

    public static SmartHome init() {
        return init("hall", "kitchen");
    }
}
