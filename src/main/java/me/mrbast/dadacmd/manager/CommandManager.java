package me.mrbast.dadacmd.manager;

import me.mrbast.dadacmd.command.CommandContext;
import me.mrbast.dadacmd.command.CommandInfo;
import me.mrbast.dadacmd.command.CommandNode;
import me.mrbast.dadacmd.tab.CommandTabCompleter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;

public class CommandManager {
    private final JavaPlugin plugin;
    private final Map<String, CommandNode> commands = new HashMap<>();

    public CommandManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerCommand(CommandNode command) {
        commands.put(command.getName(), command);
        Objects.requireNonNull(plugin.getCommand(command.getName())).setExecutor((sender, cmd, label, args) -> {
            CommandContext context = new CommandContext(sender, new HashMap<>());
            return executeCommand(cmd.getName(), context);
        });
        Objects.requireNonNull(plugin.getCommand(command.getName())).setTabCompleter(new CommandTabCompleter(this));
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