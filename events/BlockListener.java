package com.hitchainapi.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        // Custom logic for block break event
        event.getPlayer().sendMessage("You broke a block: " + event.getBlock().getType());
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        // Custom logic for block place event
        event.getPlayer().sendMessage("You placed a block: " + event.getBlock().getType());
    }
}
