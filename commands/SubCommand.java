package com.hitchainapi.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public abstract class SubCommand {

    private List<String> aliases;

    public SubCommand(String... aliases) {
        this.aliases = Arrays.asList(aliases);
    }

    public abstract String getName();

    public abstract String getPermission();

    public abstract String getDescription();

    public abstract String getUsage();

    public abstract void execute(CommandSender sender, String[] args);

    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission(getPermission());
    }

    public List<String> getAliases() {
        return aliases;
    }

    public boolean isPlayer(CommandSender sender) {
        return sender instanceof Player;
    }

    public boolean isConsole(CommandSender sender) {
        return sender instanceof ConsoleCommandSender;
    }

    public boolean checkSender(CommandSender sender) {
        if (!hasPermission(sender)) {
            sender.sendMessage("§cYou do not have permission to execute this command.");
            return false;
        }
        return true;
    }

    public boolean validateArgsLength(String[] args, int minArgs, int maxArgs) {
        if (args.length < minArgs) {
            return false;
        } else return args.length <= maxArgs;
    }

    public void sendUsage(CommandSender sender) {
        sender.sendMessage("§7Usage: " + getUsage());
    }
}

