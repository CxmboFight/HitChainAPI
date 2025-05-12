package com.hitchainapi.events;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if (entity != null) {
            // Handle entity damage (custom logic)
            System.out.println("Entity took damage: " + entity.getType());
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        if (entity != null) {
            // Handle entity death (custom logic)
            System.out.println("Entity died: " + entity.getType());
        }
    }
}
