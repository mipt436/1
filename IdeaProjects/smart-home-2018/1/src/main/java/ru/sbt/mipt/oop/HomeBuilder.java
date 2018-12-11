package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.homeComponents.Door;
import ru.sbt.mipt.oop.homeComponents.Light;
import ru.sbt.mipt.oop.homeComponents.Room;
import ru.sbt.mipt.oop.homeComponents.SmartHome;
import ru.sbt.mipt.oop.saver.FileSmartHomeSaver;
import ru.sbt.mipt.oop.saver.SmartHomeSaver;

import java.io.IOException;
import java.util.Arrays;

public class HomeBuilder {

    public static void main(String[] args) throws IOException {
        SmartHome smartHome = createSmartHome();
        SmartHomeSaver smartHomeSaver = new FileSmartHomeSaver();
        smartHomeSaver.saveSmartHome(smartHome);
    }

    public static SmartHome createSmartHome() {
        Room kitchen = new Room(Arrays.asList(new Light(false, "1"), new Light(true, "2")),
                Arrays.asList(new Door(false, "1")),
                "kitchen");
        Room bathroom = new Room(Arrays.asList(new Light(true, "3")),
                Arrays.asList(new Door(false, "2")),
                "bathroom");
        Room bedroom = new Room(Arrays.asList(new Light(false, "4"), new Light(false, "5"), new Light(false, "6")),
                Arrays.asList(new Door(true, "3")),
                "bedroom");
        Room hall = new Room(Arrays.asList(new Light(false, "7"), new Light(false, "8"), new Light(false, "9")),
                Arrays.asList(new Door(false, "4")),
                "hall");
        return new SmartHome(Arrays.asList(kitchen, bathroom, bedroom, hall));
    }

}
