package org.example.web.view.commands;

import org.example.web.view.commands.commandsImpl.GoToError;
import org.example.web.view.commands.commandsImpl.GoToMainPage;

import java.util.Map;

public class CommandExecutor {
    private Map<CommandNameEnum, Command> commandMap;

    public CommandExecutor() {
        commandMap.put(CommandNameEnum.GO_TO_MAIN_PAGE, new GoToMainPage());
        commandMap.put(CommandNameEnum.GO_TO_ERROR, new GoToError());
    }

    public void runCommand(String commandNumEnumString) {
        try {
            CommandNameEnum commandNameEnum = CommandNameEnum.valueOf(commandNumEnumString);
            if (commandMap.containsKey(commandNameEnum)) {
                commandMap.get(commandNameEnum).execute();
            } else {
                System.out.println("no particular command");
                commandMap.get(CommandNameEnum.GO_TO_ERROR).execute();
            }
        } catch (IllegalArgumentException e) {
            commandMap.get(CommandNameEnum.GO_TO_ERROR).execute();
        }
        commandMap.get(CommandNameEnum.GO_TO_MAIN_PAGE).execute();
    }
}
