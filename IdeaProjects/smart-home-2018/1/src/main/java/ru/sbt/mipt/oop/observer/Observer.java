package ru.sbt.mipt.oop.observer;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.homeComponents.SmartHome;
import ru.sbt.mipt.oop.processors.EventProcessor;

import java.util.Collection;

public interface Observer {
    void subscribe(EventProcessor processor);
    void subscribe(Collection<EventProcessor> processors);
    void unsubscribe(EventProcessor processor);
    void notifySubscribers(SmartHome smartHome, SensorEvent event);
}
