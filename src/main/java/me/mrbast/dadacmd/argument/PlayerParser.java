package me.mrbast.dadacmd.argument;

import me.mrbast.dadacmd.command.CommandContext;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerParser implements ArgumentParser<Player> {
    @Override
    public Player parse(String input) throws IllegalArgumentException {
        Player player = Bukkit.getPlayer(input);
        if (player != null) {
            return player;
        } else {
            throw new IllegalArgumentException("Player '" + input + "' not found");
        }
    }

    @Override
    public List<String> getSuggestions(CommandContext context, String input) {
        return Bukkit.getOnlinePlayers().stream()
                .map(Player::getName)
                .filter(name -> name.startsWith(input))
                .collect(Collectors.toList());
    }
}