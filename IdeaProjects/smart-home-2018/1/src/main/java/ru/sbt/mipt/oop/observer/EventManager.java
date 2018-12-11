package ru.sbt.mipt.oop.observer;

import ru.sbt.mipt.oop.homeComponents.SmartHome;

public interface EventManager {
    void runEventsCycle(SmartHome smartHome);
}
