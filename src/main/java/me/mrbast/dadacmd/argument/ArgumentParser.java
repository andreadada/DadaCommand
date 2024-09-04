package me.mrbast.dadacmd.argument;

import me.mrbast.dadacmd.command.CommandContext;

import java.util.List;

public interface ArgumentParser<T> {
    T parse(String input) throws IllegalArgumentException;
    List<String> getSuggestions(CommandContext context, String input);
}