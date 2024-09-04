package me.mrbast.dadacmd.tab;

import me.mrbast.dadacmd.command.CommandContext;

import java.util.List;

public interface SuggestionProvider {
    List<String> getSuggestions(CommandContext context, String input);
}
