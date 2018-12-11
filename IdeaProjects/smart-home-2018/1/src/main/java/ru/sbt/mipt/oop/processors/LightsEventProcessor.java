package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.homeComponents.SmartHome;
import ru.sbt.mipt.oop.homeComponents.Light;

import static ru.sbt.mipt.oop.event.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.event.SensorEventType.LIGHT_ON;

public class LightsEventProcessor implements EventProcessor {
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isLightEvent(event)) return;
        // событие от источника света
        smartHome.executeAction(object -> {
            if (object instanceof Light) {
                Light light = (Light) object;
                if (light.getId().equals(event.getObjectId())) {
                    if (event.getType() == LIGHT_ON) {
                        changeLightState(light, true, " was turned on.");
                    } else {
                        changeLightState(light, false, " was turned off.");
                    }
                }
            }
        });
    }

    private void changeLightState(Light light, boolean state, String text) {
        light.setOn(state);
        System.out.println("Light " + light.getId() + " " + text);
    }

    private boolean isLightEvent(SensorEvent event) {
        return event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF;
    }
}