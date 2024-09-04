package me.mrbast.dadacmd.command;


public abstract class Command {
    private final String name;
    private final String permission;

    public Command(String name, String permission) {
        this.name = name;
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public String getPermission() {
        return permission;
    }

    public abstract boolean execute(CommandContext context);
}
