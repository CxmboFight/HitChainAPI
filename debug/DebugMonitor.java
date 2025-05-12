package com.hitchainapi.debug;

import com.hitchainapi.HitChainPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class DebugMonitor {

    private final HitChainPlugin plugin;

    public DebugMonitor(HitChainPlugin plugin) {
        this.plugin = plugin;
    }

    public void startMonitoring() {
        new BukkitRunnable() {
            @Override
            public void run() {
                monitorPluginHealth();
            }
        }.runTaskTimer(plugin, 0, 100); // Runs every 5 seconds (100 ticks)
    }

    private void monitorPluginHealth() {
        Plugin hitchainPlugin = Bukkit.getPluginManager().getPlugin("HitChainAPI");
        if (hitchainPlugin == null || !hitchainPlugin.isEnabled()) {
            plugin.getLogger().warning("HitChainAPI plugin is not running or is disabled!");
        } else {
            plugin.getLogger().info("HitChainAPI plugin is running smoothly.");
        }
    }
}
