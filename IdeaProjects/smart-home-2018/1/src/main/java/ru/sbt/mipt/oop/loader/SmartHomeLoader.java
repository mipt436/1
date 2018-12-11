package ru.sbt.mipt.oop.loader;

import ru.sbt.mipt.oop.homeComponents.SmartHome;

import java.io.IOException;

public interface SmartHomeLoader {
    SmartHome loadSmartHome() throws IOException;
}
