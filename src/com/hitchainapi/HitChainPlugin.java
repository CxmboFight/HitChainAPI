
package com.hitchainapi;

import org.bukkit.plugin.java.JavaPlugin;
import com.hitchainapi.commands.CommandManager;
import com.hitchainapi.events.EventManager;
import com.hitchainapi.config.ConfigManager;
import com.hitchainapi.storage.DataManager;
import com.hitchainapi.utils.MessageUtil;
import com.hitchainapi.utils.DebugLogger;

public class HitChainPlugin extends JavaPlugin {

    private HitChainAPI api;   // Reference to your core API class

    @Override
    public void onEnable() {
        // Initialize the API instance
        api = HitChainAPI.getInstance();
        
        // Initialize all plugin components
        initConfig();
        initCommands();
        initEvents();
        initStorage();
        initDebugging();

        // Log a message that the plugin has been enabled
        MessageUtil.sendConsoleMessage("HitChainPlugin has been successfully enabled!");
    }

    @Override
    public void onDisable() {
        // Perform cleanup tasks like saving data or releasing resources
        api.getDataManager().saveAllData();  // Save all player data
        MessageUtil.sendConsoleMessage("HitChainPlugin has been disabled.");
    }

    // Initialize the configuration system
    private void initConfig() {
        ConfigManager configManager = api.getConfigManager();
        configManager.loadConfigs(); // Load configuration files like config.yml
    }

    // Register commands
    private void initCommands() {
        CommandManager commandManager = api.getCommandManager();
        commandManager.registerCommands();  // Register the plugin commands
    }

    // Register event listeners
    private void initEvents() {
        EventManager eventManager = api.getEventManager();
        getServer().getPluginManager().registerEvents(eventManager, this);  // Register event handlers
    }

    // Initialize the data storage system
    private void initStorage() {
        DataManager dataManager = api.getDataManager();
        dataManager.setupStorage();  // Setup storage backends like SQLite or MySQL
    }

    // Initialize debugging tools
    private void initDebugging() {
        DebugLogger debugLogger = api.getDebugLogger();
        debugLogger.enableDebugging();  // Enable logging and debugging during development
    }

    // Accessor for the main API instance (this will be used by other classes)
    public HitChainAPI getAPI() {
        return api;
    }
}
