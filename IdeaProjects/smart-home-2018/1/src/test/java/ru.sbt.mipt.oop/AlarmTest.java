package ru.sbt.mipt.oop;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.alarmStates.ActivatedAlarmState;
import ru.sbt.mipt.oop.alarmStates.AlarmModeAlarmState;
import ru.sbt.mipt.oop.alarmStates.DeactivatedAlarmState;
import ru.sbt.mipt.oop.homeComponents.Alarm;

import static org.junit.Assert.assertTrue;

public class AlarmTest {
    private Alarm alarm;

    @Before
    public void init() {
        alarm = new Alarm();
    }

    @Test
    public void activateDeactivatedAlarm() {
        assertTrue(alarm.getAlarmState() instanceof DeactivatedAlarmState);
        alarm.activate("1234");
        assertTrue(alarm.getAlarmState() instanceof ActivatedAlarmState);
    }

    @Test
    public void deactivateActivatedAlarm() {
        alarm.activate("1234");
        alarm.deactivate("1234");
        assertTrue(alarm.getAlarmState() instanceof DeactivatedAlarmState);
    }

    @Test
    public void deactivateActivatedAlarmWithWrongPassword() {
        alarm.activate("1234");
        alarm.deactivate("4321");
        assertTrue(alarm.getAlarmState() instanceof AlarmModeAlarmState);
    }

    @Test
    public void deactivateAlarmedAlarm() {
        alarm.activate("1234");
        alarm.deactivate("4321");
        assertTrue(alarm.getAlarmState() instanceof AlarmModeAlarmState);
        alarm.deactivate("1234");
        assertTrue(alarm.getAlarmState() instanceof DeactivatedAlarmState);
    }
}
