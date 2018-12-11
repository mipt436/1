package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.homeComponents.SmartHome;

import static ru.sbt.mipt.oop.event.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.event.SensorEventType.ALARM_DEACTIVATE;

public class AlarmEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isAlarmEvent(event)) return;
        if (event.getType() == ALARM_ACTIVATE) {
            smartHome.getAlarm().activate(event.getObjectId());
        }
        if (event.getType() == ALARM_DEACTIVATE) {
            smartHome.getAlarm().deactivate(event.getObjectId());
        }

    }

    private boolean isAlarmEvent(SensorEvent event) {
        return event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE;
    }
}
