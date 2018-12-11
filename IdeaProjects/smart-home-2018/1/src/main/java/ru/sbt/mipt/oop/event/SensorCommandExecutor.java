package ru.sbt.mipt.oop.event;

public class SensorCommandExecutor {
    public static void executeCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }
}