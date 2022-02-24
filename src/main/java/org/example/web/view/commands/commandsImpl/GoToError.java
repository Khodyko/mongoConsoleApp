package org.example.web.view.commands.commandsImpl;

import org.example.web.view.commands.Command;

public class GoToError implements Command {
    public GoToError() {
    }

    @Override
    public void execute() {
        System.err.println("Error");
    }
}
