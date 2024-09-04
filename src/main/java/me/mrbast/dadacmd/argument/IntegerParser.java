package me.mrbast.dadacmd.argument;

import me.mrbast.dadacmd.command.CommandContext;

import java.util.List;

public class IntegerParser implements ArgumentParser<Integer> {
    @Override
    public Integer parse(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid integer: " + input);
        }
    }

    @Override
    public List<String> getSuggestions(CommandContext context, String input) {
        return List.of();
    }
}