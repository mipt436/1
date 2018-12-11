package ru.sbt.mipt.oop.remoteControl;

public interface RemoteControlRegistry {
    void registerRemoteControl(RemoteControl remoteControl, String rcId);
}