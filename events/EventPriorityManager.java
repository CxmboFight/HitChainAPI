package com.hitchainapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventPriorityManager {

    public void setEventPriority(Listener listener, Event event, int priority) {
        // Custom logic to set event priority
        // Lower value means higher priority
        if (event instanceof EntityDamageEvent) {
            // Set event priority for EntityDamageEvent
        } else if (event instanceof PlayerInteractEvent) {
            // Set event priority for PlayerInteractEvent
        }

        // Priority could affect how events are handled (default is NORMAL)
        // Adjust as necessary based on your needs
    }
}

