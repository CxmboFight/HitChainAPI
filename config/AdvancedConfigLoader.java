package com.hitchainapi.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class AdvancedConfigLoader {

    private final JavaPlugin plugin;
    private final File configFile;
    private FileConfiguration config;

    public AdvancedConfigLoader(JavaPlugin plugin, String configName) {
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), configName);
        if (!configFile.exists()) {
            plugin.saveResource(configName, false);
        }
        this.config = plugin.getConfig();
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void reloadConfig() {
        plugin.reloadConfig();
        this.config = plugin.getConfig();
    }

    public void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            plugin.getLogger().severe("Could not save config file!");
            e.printStackTrace();
        }
    }

    public void set(String path, Object value) {
        config.set(path, value);
        saveConfig();
    }

    public Object get(String path) {
        return config.get(path);
    }

    public boolean contains(String path) {
        return config.contains(path);
    }
}
