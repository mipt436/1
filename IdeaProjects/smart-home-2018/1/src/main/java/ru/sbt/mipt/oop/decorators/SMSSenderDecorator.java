package ru.sbt.mipt.oop.decorators;

import ru.sbt.mipt.oop.processors.EventProcessor;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.homeComponents.SmartHome;
import ru.sbt.mipt.oop.alarmStates.ActivatedAlarmState;
import ru.sbt.mipt.oop.alarmStates.AlarmModeAlarmState;

public class SMSSenderDecorator implements EventProcessor {
    final private EventProcessor processor;

    SMSSenderDecorator(EventProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (smartHome.getAlarm().getAlarmState() instanceof ActivatedAlarmState || smartHome.getAlarm().getAlarmState() instanceof AlarmModeAlarmState) {
            System.out.println("Sending sms");
            return;
        }
        processor.processEvent(smartHome, event);
    }
}
