package com.hitchainapi.api;

import org.bukkit.entity.Player;

public interface HitChainAPIInterface {

    /**
     * Gets the current version of the plugin.
     *
     * @return The version of the HitChainAPI plugin.
     */
    String getPluginVersion();

    /**
     * Sends a custom message to the player with color support and placeholders.
     * This can be used by external developers to send messages formatted by the plugin.
     *
     * @param player  The player to send the message to.
     * @param message The message to send to the player.
     */
    void sendMessageToPlayer(Player player, String message);

    /**
     * Gives a player a custom item with a specified ID and amount.
     * External developers can use this to give items to players with special properties.
     *
     * @param player  The player to whom the item will be given.
     * @param itemId  The ID of the item to give (can be customized).
     * @param amount  The amount of the item to give.
     */
    void giveCustomItem(Player player, String itemId, int amount);

    /**
     * Tracks a player's stat (e.g., kills, score, etc.) in an external system or database.
     * This can be used by third-party developers to track player data across servers.
     *
     * @param player  The player whose stat is being tracked.
     * @param statKey The unique key for the stat.
     * @param value   The value of the stat to be tracked.
     */
    void trackPlayerStat(Player player, String statKey, int value);

    /**
     * Runs a custom task asynchronously using the plugin’s scheduler.
     * This method allows external developers to run their own code without blocking the main thread.
     *
     * @param task The task to execute (Runnable).
     */
    void runCustomTask(Runnable task);

    /**
     * Checks if a player has a specific permission.
     * This could be useful for external developers to check player permissions for certain actions.
     *
     * @param player    The player whose permission is being checked.
     * @param permission The permission to check.
     * @return True if the player has the permission, false otherwise.
     */
    boolean hasPermission(Player player, String permission);
    
    /**
     * Retrieves player statistics, such as kills, deaths, etc., if the plugin supports it.
     * External plugins can use this to get player data for various features (e.g., stats boards).
     *
     * @param player The player whose stats are to be retrieved.
     * @param statKey The key for the specific stat.
     * @return The value of the requested stat, or -1 if the stat doesn't exist.
     */
    int getPlayerStat(Player player, String statKey);
}

