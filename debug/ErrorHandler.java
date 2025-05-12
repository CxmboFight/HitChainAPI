package com.hitchainapi.debug;

import com.hitchainapi.HitChainPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ErrorHandler {

    private final HitChainPlugin plugin;

    public ErrorHandler(HitChainPlugin plugin) {
        this.plugin = plugin;
    }

    public void handleError(Exception e) {
        plugin.getLogger().severe("An error occurred: " + e.getMessage());
        e.printStackTrace();

        // Optionally, you can send the error message to online admins or all players
        Bukkit.getOnlinePlayers().forEach(player -> sendErrorToPlayer(player, e));

        // Handle other recovery or reporting tasks here
    }

    private void sendErrorToPlayer(Player player, Exception e) {
        player.sendMessage("§cAn error occurred in the plugin! Please contact an admin.");
        player.sendMessage("Error details: §7" + e.getMessage());
    }
}
