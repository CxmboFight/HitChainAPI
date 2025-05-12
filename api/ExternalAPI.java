package com.hitchainapi.api;

import com.hitchainapi.HitChainAPI;
import com.hitchainapi.utils.DebugLogger;
import org.bukkit.entity.Player;

public class ExternalAPI {

    private static HitChainAPI pluginInstance;

    public ExternalAPI(HitChainAPI plugin) {
        pluginInstance = plugin;
    }

    /**
     * Example method to give a player an item with custom properties.
     * This method is an example of how external developers can interact with your plugin's features.
     *
     * @param player The player to whom the item will be given.
     * @param itemId The ID of the item to give (can be customized).
     * @param amount The amount of the item to give.
     */
    public static void giveCustomItem(Player player, String itemId, int amount) {
        if (player == null || itemId == null || itemId.isEmpty()) {
            DebugLogger.log("Invalid arguments in giveCustomItem. Cannot proceed.");
            return;
        }

        // Create item based on the itemId (this could interact with an ItemManager or similar class)
        // For example: an item manager method could generate items with custom attributes, names, lore, etc.
        ItemBuilder item = new ItemBuilder(itemId)
                .setAmount(amount)
                .setDisplayName("§6Special " + itemId) // Example: Item with custom name
                .setLore("§7This item was given by HitChainAPI");

        player.getInventory().addItem(item.build());
        DebugLogger.log("Gave " + amount + " of " + itemId + " to " + player.getName());
    }

    /**
     * Example method to track a player's stats using an external API.
     * External developers can use this method to store player statistics or data within their own systems.
     *
     * @param player The player whose stats are being tracked.
     * @param statKey The unique key for the stat.
     * @param value The value of the stat to be tracked.
     */
    public static void trackPlayerStat(Player player, String statKey, int value) {
        if (player == null || statKey == null || statKey.isEmpty()) {
            DebugLogger.log("Invalid arguments in trackPlayerStat. Cannot proceed.");
            return;
        }

        // Assuming DataManager is a class handling data storage and management (like SQLite or MySQL)
        DataManager dataManager = new DataManager(pluginInstance);
        dataManager.saveStat(player.getUniqueId(), statKey, value);

        DebugLogger.log("Tracked stat for " + player.getName() + ": " + statKey + " = " + value);
    }

    /**
     * Example method to send a custom message to a player.
     * This shows how external plugins can send messages with placeholders and formatting.
     *
     * @param player The player to send the message to.
     * @param message The message to send.
     */
    public static void sendCustomMessage(Player player, String message) {
        if (player == null || message == null || message.isEmpty()) {
            DebugLogger.log("Invalid arguments in sendCustomMessage. Cannot proceed.");
            return;
        }

        // Send a formatted message to the player with color support and placeholders.
        String formattedMessage = MessageUtil.formatMessage(message);  // Assuming MessageUtil handles color/placeholder formatting
        player.sendMessage(formattedMessage);
        DebugLogger.log("Sent message to " + player.getName() + ": " + formattedMessage);
    }

    /**
     * Example method to start a custom task for an external plugin.
     * This method demonstrates how external developers can schedule custom tasks.
     *
     * @param task The task to execute (Runnable).
     */
    public static void runCustomTask(Runnable task) {
        if (task == null) {
            DebugLogger.log("Invalid arguments in runCustomTask. Cannot proceed.");
            return;
        }

        // Run the task asynchronously using the plugin's scheduler.
        HitChainAPI.getInstance().getServer().getScheduler().runTask(pluginInstance, task);
        DebugLogger.log("Custom task has been scheduled.");
    }

    /**
     * Example of an API method to get the version of the plugin.
     * External developers might want to check the version of your plugin before making API calls.
     *
     * @return The current version of the HitChainAPI plugin.
     */
    public static String getPluginVersion() {
        return "HitChainAPI Version: " + pluginInstance.getDescription().getVersion();
    }
}

