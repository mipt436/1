package ru.sbt.mipt.oop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import ru.sbt.mipt.oop.config.MyConfiguration;
import ru.sbt.mipt.oop.loader.SmartHomeLoader;
import ru.sbt.mipt.oop.observer.EventManager;

import java.io.IOException;

public class Application {
    public static void main(String... args) throws IOException {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        EventManager eventManager = context.getBean(EventManager.class);
        SmartHomeLoader smartHomeLoader = context.getBean(SmartHomeLoader.class);
        eventManager.runEventsCycle(smartHomeLoader.loadSmartHome());
    }
}
