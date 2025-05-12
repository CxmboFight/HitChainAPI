package com.hitchainapi.events;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import com.hitchainapi.HitChainPlugin;

public class EventManager {

    private final HitChainPlugin plugin;

    public EventManager(HitChainPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerEvents() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new BlockListener(), plugin);
        pluginManager.registerEvents(new EntityListener(), plugin);
        pluginManager.registerEvents(new PlayerListener(), plugin);
    }
}

