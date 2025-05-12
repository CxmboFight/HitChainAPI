package com.hitchainapi.utils;

import org.bukkit.ChatColor;

public class MessageUtil {

    /**
     * Format a message to be colored using ChatColor.
     * @param message The message to be formatted.
     * @return The formatted message with colors.
     */
    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    /**
     * Send a colored message to a player.
     * @param player The player to send the message to.
     * @param message The message to be sent.
     */
    public static void sendMessage(org.bukkit.entity.Player player, String message) {
        player.sendMessage(colorize(message));
    }

    /**
     * Send a colored message to all players in the server.
     * @param message The message to be sent.
     */
    public static void broadcastMessage(String message) {
        org.bukkit.Bukkit.broadcastMessage(colorize(message));
    }

    /**
     * Format a message to include placeholders for dynamic data.
     * @param message The message with placeholders.
     * @param replacements The dynamic data to replace placeholders.
     * @return The formatted message.
     */
    public static String formatMessage(String message, Object... replacements) {
        for (int i = 0; i < replacements.length; i++) {
            message = message.replace("{" + i + "}", replacements[i].toString());
        }
        return colorize(message);
    }

    /**
     * Send a formatted message to a player with dynamic data.
     * @param player The player to send the message to.
     * @param message The message with placeholders.
     * @param replacements The dynamic data to replace placeholders.
     */
    public static void sendFormattedMessage(org.bukkit.entity.Player player, String message, Object... replacements) {
        player.sendMessage(formatMessage(message, replacements));
    }

    /**
     * Send a formatted message to all players with dynamic data.
     * @param message The message with placeholders.
     * @param replacements The dynamic data to replace placeholders.
     */
    public static void broadcastFormattedMessage(String message, Object... replacements) {
        org.bukkit.Bukkit.broadcastMessage(formatMessage(message, replacements));
    }
}

