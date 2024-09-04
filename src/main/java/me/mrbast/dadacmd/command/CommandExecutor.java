package me.mrbast.dadacmd.command;

@FunctionalInterface
public interface CommandExecutor {
    boolean execute(CommandContext context);
}