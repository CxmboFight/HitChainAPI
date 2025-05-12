package com.hitchainapi.config;

import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {

    private final AdvancedConfigLoader configLoader;

    public ConfigManager(JavaPlugin plugin) {
        this.configLoader = new AdvancedConfigLoader(plugin, "config.yml");
    }

    public AdvancedConfigLoader getConfigLoader() {
        return configLoader;
    }

    public void loadDefaults() {
        configLoader.set("someSetting", "defaultValue");
        configLoader.set("enableFeatureX", true);
    }

    public void reload() {
        configLoader.reloadConfig();
    }
}
