package ru.sbt.mipt.oop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.adapter.EventManagerAdapter;
import ru.sbt.mipt.oop.loader.FileSmartHomeLoader;
import ru.sbt.mipt.oop.loader.SmartHomeLoader;
import ru.sbt.mipt.oop.observer.EventManager;
import ru.sbt.mipt.oop.observer.HomeEventsObserver;
import ru.sbt.mipt.oop.observer.Observer;
import ru.sbt.mipt.oop.processors.DoorEventProcessor;
import ru.sbt.mipt.oop.processors.EventProcessor;
import ru.sbt.mipt.oop.processors.HallDoorEventProcessor;
import ru.sbt.mipt.oop.processors.LightsEventProcessor;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class MyConfiguration {
    MyConfiguration() {

    }

    @Bean
    public EventManager eventManager() {
        Observer observer = configureSimpleObserver();
        return new EventManagerAdapter(observer);
    }

    @Bean
    public SmartHomeLoader smartHomeLoader() {
        return new FileSmartHomeLoader();
    }

    private static Observer configureSimpleObserver() {
        Observer observer = new HomeEventsObserver();
        observer.subscribe(configureEventProcessors());
        return observer;
    }

    private static Collection<EventProcessor> configureEventProcessors() {
        Collection<EventProcessor> eventProcessors = new ArrayList<>();
        eventProcessors.add(new LightsEventProcessor());
        eventProcessors.add(new DoorEventProcessor());
        eventProcessors.add(new HallDoorEventProcessor());
        return eventProcessors;
    }
}



