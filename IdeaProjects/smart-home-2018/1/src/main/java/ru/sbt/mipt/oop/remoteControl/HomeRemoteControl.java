package ru.sbt.mipt.oop.remoteControl;

import ru.sbt.mipt.oop.commands.Command;

import java.util.HashMap;

public class HomeRemoteControl implements RemoteControl {
    final private HashMap<String, Command> buttons;

    public HomeRemoteControl() {
        buttons = new HashMap<>();
    }

    public void setCommandOnButton(String buttonCode, Command command) {
        if (buttonCode.length() == 1) {
            char buttonCharCode = buttonCode.charAt(0);
            if (buttonCharCode <= 'D' && buttonCharCode >= 'A' || buttonCharCode <= '4' && buttonCharCode >= '1') {
                buttons.put(buttonCode, command);
            }
        }
    }

    @Override
    public void onButtonPressed(String buttonCode) {
        Command command = buttons.get(buttonCode);
        if (command != null) command.execute();
    }
}
