
package com.hitchainapi;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;
import com.hitchainapi.commands.CommandManager;
import com.hitchainapi.config.ConfigManager;
import com.hitchainapi.events.EventManager;
import com.hitchainapi.storage.DataManager;
import com.hitchainapi.utils.DebugLogger;
import com.hitchainapi.utils.MessageUtil;

public class HitChainAPI extends JavaPlugin {

    private static HitChainAPI instance;
    private ConfigManager configManager;
    private CommandManager commandManager;
    private EventManager eventManager;
    private DataManager dataManager;
    private DebugLogger debugLogger;

    // Called when the plugin is enabled
    @Override
    public void onEnable() {
        instance = this;

        // Initialize core systems
        initConfig();
        initCommands();
        initEvents();
        initStorage();
        initDebugging();

        // Log a startup message
        MessageUtil.sendConsoleMessage("HitChainAPI has been successfully loaded!");
    }

    // Called when the plugin is disabled
    @Override
    public void onDisable() {
        // Save any important data if needed
        dataManager.saveAllData();
        MessageUtil.sendConsoleMessage("HitChainAPI has been disabled.");
    }

    // Initialize the configuration system
    private void initConfig() {
        configManager = new ConfigManager();
        configManager.loadConfigs();
    }

    // Initialize commands
    private void initCommands() {
        commandManager = new CommandManager(this);
        commandManager.registerCommands();
    }

    // Initialize event listeners
    private void initEvents() {
        PluginManager pluginManager = getServer().getPluginManager();
        eventManager = new EventManager();
        pluginManager.registerEvents(eventManager, this);
    }

    // Initialize the storage system (SQLite, MySQL, etc.)
    private void initStorage() {
        dataManager = new DataManager();
        dataManager.setupStorage();
    }

    // Initialize debugging tools (for development)
    private void initDebugging() {
        debugLogger = new DebugLogger();
        debugLogger.enableDebugging();
    }

    // Get the instance of this plugin (for other classes to access)
    public static HitChainAPI getInstance() {
        return instance;
    }

    // Example method for retrieving the config manager
    public ConfigManager getConfigManager() {
        return configManager;
    }

    // Example method for getting the command manager
    public CommandManager getCommandManager() {
        return commandManager;
    }

    // Example method for getting the data manager
    public DataManager getDataManager() {
        return dataManager;
    }

    // Example method for getting the debug logger
    public DebugLogger getDebugLogger() {
        return debugLogger;
    }

    // This could be used in the future to expose more API features
    public void registerAPI() {
        // Register API functionality if needed
    }
}
