package com.hitchainapi.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Custom logic for player join event
        event.getPlayer().sendMessage("Welcome to the server, " + event.getPlayer().getName());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        // Custom logic for player quit event
        event.getPlayer().sendMessage("Goodbye, " + event.getPlayer().getName());
    }
}
