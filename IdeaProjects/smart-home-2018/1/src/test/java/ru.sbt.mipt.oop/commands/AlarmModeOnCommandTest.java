package ru.sbt.mipt.oop.commands;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.InitTestHome;
import ru.sbt.mipt.oop.homeComponents.SmartHome;
import ru.sbt.mipt.oop.alarmStates.AlarmModeAlarmState;

import static org.junit.Assert.assertTrue;

public class AlarmModeOnCommandTest {
    private SmartHome smartHome;
    private Command command;

    @Before
    public void init() {
        smartHome = InitTestHome.init();
        command = new AlarmModeOnCommand(smartHome);
    }

    @Test
    public void successTest() {
        command.execute();
        assertTrue(smartHome.getAlarm().getAlarmState() instanceof AlarmModeAlarmState);
    }
}
