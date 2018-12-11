package ru.sbt.mipt.oop.homeComponents;

import ru.sbt.mipt.oop.alarmStates.AlarmState;
import ru.sbt.mipt.oop.alarmStates.DeactivatedAlarmState;

public class Alarm {
    private AlarmState alarmState;

    public Alarm() {
        this.alarmState = new DeactivatedAlarmState(this);
    }

    public AlarmState getAlarmState() {
        return alarmState;
    }

    public void changeAlarmState(AlarmState alarmState) {
        this.alarmState = alarmState;
    }

    public void activate(String password) {
        alarmState.activate(password);
    }

    public void deactivate(String password) {
        alarmState.deactivate(password);
    }

    public void setAlarmMode() {
        alarmState.setAlarmMode();
    }
}
