package me.mrbast.dadacmd.manager;

import me.mrbast.dadacmd.command.CommandContext;
import me.mrbast.dadacmd.command.CommandNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;

public class CommandManager {
    private final Map<String, CommandNode> commands = new HashMap<>();

    public void registerCommand(CommandNode command) {
        commands.put(command.getName(), command);
    }

    public boolean executeCommand(String name, CommandContext context) {
        CommandNode command = commands.get(name);
        if (command != null) {
            return command.execute(context);
        }
        return false;
    }

    public List<String> getSuggestions(String name, CommandContext context, String[] args) {
        CommandNode command = commands.get(name);
        if (command != null) {
            return command.getSuggestions(context, args);
        }
        return Collections.emptyList();
    }
}