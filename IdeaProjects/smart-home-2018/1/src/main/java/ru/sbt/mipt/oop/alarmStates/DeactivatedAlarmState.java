package ru.sbt.mipt.oop.alarmStates;

import ru.sbt.mipt.oop.homeComponents.Alarm;

public class DeactivatedAlarmState implements AlarmState {
    private Alarm alarm;

    public DeactivatedAlarmState(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate(String password) {
        alarm.changeAlarmState(new ActivatedAlarmState(alarm, password));
    }

    @Override
    public void deactivate(String password) {

    }

    @Override
    public void setAlarmMode() {
        alarm.changeAlarmState(new AlarmModeAlarmState(alarm, "0000"));
        alarm.setAlarmMode();
    }
}
