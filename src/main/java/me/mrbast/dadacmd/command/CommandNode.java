package me.mrbast.dadacmd.command;

import me.mrbast.dadacmd.argument.ArgumentParser;

import java.util.*;
import java.util.stream.Collectors;

public abstract class CommandNode {
    private final String name;
    private final String permission;
    private final List<CommandNode> children = new ArrayList<>();
    private final Map<String, ArgumentParser<?>> parsers = new HashMap<>();

    public CommandNode(String name, String permission) {
        this.name = name;
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public String getPermission() {
        return permission;
    }

    public void addChild(CommandNode child) {
        children.add(child);
    }

    public List<CommandNode> getChildren() {
        return children;
    }

    public void addParser(String argumentName, ArgumentParser<?> parser) {
        parsers.put(argumentName, parser);
    }

    public abstract boolean execute(CommandContext context);

    public List<String> getSuggestions(CommandContext context, String[] args) {
        if (args.length == 0) {
            return getChildren().stream().map(CommandNode::getName).collect(Collectors.toList());
        } else {
            for (CommandNode child : getChildren()) {
                if (child.getName().equalsIgnoreCase(args[0])) {
                    return child.getSuggestions(context, Arrays.copyOfRange(args, 1, args.length));
                }
            }
            ArgumentParser<?> parser = parsers.get(args[0]);
            if (parser != null) {
                return parser.getSuggestions(context, args[args.length - 1]);
            }
        }
        return Collections.emptyList();
    }
}