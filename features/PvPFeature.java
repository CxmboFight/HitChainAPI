package com.hitchainapi.features;

import com.hitchainapi.HitChainPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PvPFeature implements Listener {

    private final HitChainPlugin plugin;

    public PvPFeature(HitChainPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player attacker = (Player) event.getDamager();
            Player victim = (Player) event.getEntity();
            // Custom PvP logic, such as combo tracking or special abilities
            handlePvP(attacker, victim, event);
        }
    }

    private void handlePvP(Player attacker, Player victim, EntityDamageByEntityEvent event) {
        // Example PvP logic: giving the attacker a reward on a successful hit
        attacker.sendMessage("You hit " + victim.getName() + " for " + event.getDamage() + " damage!");
        // You can implement combo tracking, damage modifiers, or special PvP effects here.
    }
}

