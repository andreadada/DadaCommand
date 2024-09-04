package me.mrbast.dadacmd.command;

import me.mrbast.dadacmd.argument.ArgumentParser;

import java.util.Collections;
import java.util.List;

public class CommandBuilder {
    private final CommandNode root;
    private CommandNode currentNode;

    public CommandBuilder(String name, String permission) {
        this.root = new CommandNode(name, permission) {
            @Override
            public boolean execute(CommandContext context) {
                return false;
            }

            @Override
            public List<String> getSuggestions(CommandContext context, String[] args) {
                return Collections.emptyList();
            }
        };
        this.currentNode = root;
    }

    public CommandBuilder literal(String name) {
        CommandNode literalNode = new CommandNode(name, null) {
            @Override
            public boolean execute(CommandContext context) {
                return false;
            }

            @Override
            public List<String> getSuggestions(CommandContext context, String[] args) {
                return Collections.emptyList();
            }
        };
        currentNode.addChild(literalNode);
        currentNode = literalNode;
        return this;
    }

    public CommandBuilder required(String name, ArgumentParser<?> parser) {
        currentNode.addParser(name, parser);
        return this;
    }

    public CommandBuilder optional(String name, ArgumentParser<?> parser) {
        currentNode.addParser(name, parser);
        return this;
    }

    public CommandBuilder handler(CommandExecutor executor) {
        currentNode = new CommandNode(currentNode.getName(), currentNode.getPermission()) {
            @Override
            public boolean execute(CommandContext context) {
                return executor.execute(context);
            }

            @Override
            public List<String> getSuggestions(CommandContext context, String[] args) {
                return Collections.emptyList();
            }
        };
        return this;
    }

    public CommandNode build() {
        return root;
    }
}