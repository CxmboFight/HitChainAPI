package com.hitchainapi.commands;

import com.hitchainapi.HitChainAPI;
import com.hitchainapi.utils.MessageUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HitChainCommand extends BaseCommand {

    public HitChainCommand(HitChainAPI plugin) {
        super(plugin);
    }

    @Override
    public String getName() {
        return "hitchain"; // The name of the command (e.g., "/hitchain")
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                // Display the basic usage or help
                player.sendMessage(MessageUtil.colorize("&6&lHitChainAPI &7- The Ultimate Minecraft API"));
                player.sendMessage(MessageUtil.colorize("&7Use &6/hitchain help &7for more information."));
                return;
            }

            // Handle specific subcommands or arguments
            switch (args[0].toLowerCase()) {
                case "help":
                    sendHelpMessage(player);
                    break;

                case "version":
                    sendVersionInfo(player);
                    break;

                case "status":
                    sendStatus(player);
                    break;

                default:
                    player.sendMessage(MessageUtil.colorize("&cUnknown subcommand. Use /hitchain help for help."));
                    break;
            }
        } else {
            // If the sender is not a player
            sender.sendMessage(MessageUtil.colorize("&cThis command can only be executed by a player."));
        }
    }

    /**
     * Sends the help message for the HitChain command.
     */
    private void sendHelpMessage(Player player) {
        player.sendMessage(MessageUtil.colorize("&6&lHitChainAPI Help"));
        player.sendMessage(MessageUtil.colorize("&7/hitchain help - Show this help message"));
        player.sendMessage(MessageUtil.colorize("&7/hitchain version - Show plugin version"));
        player.sendMessage(MessageUtil.colorize("&7/hitchain status - Show plugin status"));
    }

    /**
     * Sends the version information of the plugin.
     */
    private void sendVersionInfo(Player player) {
        String version = plugin.getDescription().getVersion();
        player.sendMessage(MessageUtil.colorize("&6HitChainAPI Version: &7" + version));
    }

    /**
     * Sends the current status of the plugin.
     */
    private void sendStatus(Player player) {
        // You can dynamically check your plugin's status here
        boolean isPluginEnabled = plugin.isEnabled(); // Example of checking if the plugin is enabled
        player.sendMessage(MessageUtil.colorize("&6Plugin Status: &7" + (isPluginEnabled ? "Enabled" : "Disabled")));
    }
}

