package me.mrbast.dadacmd;

import me.mrbast.dadacmd.manager.CommandManager;
import me.mrbast.dadacmd.tab.CommandTabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public class DadaCMD {

    private static final DadaCMD instance = new DadaCMD();
    public static DadaCMD getInstance() { return instance; }

    private DadaCMD(){}


    private CommandManager commandManager;

    public void init(JavaPlugin plugin) {
        commandManager = new CommandManager();
    }

    public CommandManager getCommandManager() {

        return commandManager;
    }

}
