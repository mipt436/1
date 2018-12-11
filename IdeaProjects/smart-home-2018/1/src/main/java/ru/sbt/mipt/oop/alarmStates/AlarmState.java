package ru.sbt.mipt.oop.alarmStates;

public interface AlarmState {
    void activate(String password);

    void deactivate(String password);

    void setAlarmMode();
}
