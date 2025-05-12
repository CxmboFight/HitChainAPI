package com.hitchainapi.commands;

import com.hitchainapi.HitChainAPI;
import com.hitchainapi.utils.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class CommandManager implements CommandExecutor {

    private final HitChainAPI plugin;
    private final Map<String, BaseCommand> commandMap = new HashMap<>();

    public CommandManager(HitChainAPI plugin) {
        this.plugin = plugin;
        initializeCommands();
    }

    /**
     * Initialize the available commands in the plugin.
     * Registers all commands in the plugin, including their executors.
     */
    private void initializeCommands() {
        // Register example commands here
        registerCommand(new HitChainCommand(plugin));

        // Add more commands as needed
    }

    /**
     * Registers a command with the manager.
     * @param command The command to register
     */
    public void registerCommand(BaseCommand command) {
        commandMap.put(command.getName(), command);
        plugin.getCommand(command.getName()).setExecutor(this);
    }

    /**
     * Handles the execution of commands. This method will be invoked by the Bukkit command system.
     *
     * @param sender  The sender of the command (can be a player or console)
     * @param label   The alias of the command
     * @param args    The arguments passed with the command
     * @return true if the command was successfully executed, false otherwise
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if the sender has permission to execute the command
        if (!(sender instanceof Player) && !commandMap.containsKey(label)) {
            sender.sendMessage(MessageUtil.colorize("&cThis command can only be executed by a player."));
            return false;
        }

        // Command lookup
        BaseCommand baseCommand = commandMap.get(label);

        if (baseCommand == null) {
            return false; // Command not found
        }

        // Check for permissions
        if (!baseCommand.hasPermission(sender)) {
            sender.sendMessage(MessageUtil.colorize("&cYou do not have permission to execute this command."));
            return false;
        }

        // Execute the command
        try {
            baseCommand.execute(sender, args);
        } catch (Exception e) {
            sender.sendMessage(MessageUtil.colorize("&cAn error occurred while executing the command."));
            e.printStackTrace();
        }

        return true;
    }
}

