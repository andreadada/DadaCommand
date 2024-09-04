package me.mrbast.dadacmd.command;

import org.bukkit.command.CommandSender;

import java.util.Map;
import java.util.Optional;

public class CommandContext {
    private final CommandSender sender;
    private final Map<String, Object> arguments;

    public CommandContext(CommandSender sender, Map<String, Object> arguments) {
        this.sender = sender;
        this.arguments = arguments;
    }

    public CommandSender getSender() {
        return sender;
    }

    public <T> T getArgument(String name) {
        return (T) arguments.get(name);
    }

    public <T> Optional<T> getOptionalArgument(String name) {
        return Optional.ofNullable((T) arguments.get(name));
    }
}