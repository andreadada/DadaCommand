package me.mrbast.dadacmd.tab;

import me.mrbast.dadacmd.command.CommandContext;
import me.mrbast.dadacmd.manager.CommandManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.HashMap;
import java.util.List;

public class CommandTabCompleter implements TabCompleter {
    private final CommandManager commandManager;

    public CommandTabCompleter(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        CommandContext context = new CommandContext(sender, new HashMap<>());
        return commandManager.getSuggestions(command.getName(), context, args);
    }
}