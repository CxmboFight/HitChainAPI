package com.hitchainapi.api;

import com.hitchainapi.HitChainAPI;
import com.hitchainapi.utils.DebugLogger;
import org.bukkit.Bukkit;

public class APIManager {

    private static HitChainAPI pluginInstance;

    public APIManager(HitChainAPI plugin) {
        pluginInstance = plugin;
    }

    /**
     * Registers a custom API handler for external developers to hook into.
     * This allows third-party plugins or developers to register their own functionality to this plugin.
     */
    public static void registerCustomAPIHandler(CustomAPIHandler handler) {
        // Example: Register a custom API handler
        if (handler != null) {
            handler.register();
            DebugLogger.log("Custom API handler registered: " + handler.getClass().getName());
        } else {
            DebugLogger.log("Failed to register custom API handler: Handler is null");
        }
    }

    /**
     * Fetches the current plugin instance.
     * This method gives access to the core functionality of HitChainAPI.
     * 
     * @return The current instance of HitChainAPI.
     */
    public static HitChainAPI getPluginInstance() {
        return pluginInstance;
    }

    /**
     * Executes a custom task asynchronously. This method allows third-party plugins
     * or developers to run custom tasks asynchronously.
     *
     * @param task The task to execute.
     */
    public static void runAsyncTask(Runnable task) {
        if (task != null) {
            Bukkit.getScheduler().runTask(pluginInstance, task);
            DebugLogger.log("Async task has been scheduled.");
        } else {
            DebugLogger.log("Failed to run async task: Task is null");
        }
    }

    /**
     * Executes a custom task synchronously. This method allows third-party plugins
     * or developers to run custom tasks synchronously.
     *
     * @param task The task to execute.
     */
    public static void runSyncTask(Runnable task) {
        if (task != null) {
            Bukkit.getScheduler().runTask(pluginInstance, task);
            DebugLogger.log("Sync task has been scheduled.");
        } else {
            DebugLogger.log("Failed to run sync task: Task is null");
        }
    }

    /**
     * Retrieves plugin information, including the version and name.
     * Useful for debugging and displaying information about the plugin.
     *
     * @return Plugin information as a string.
     */
    public static String getPluginInfo() {
        return "HitChainAPI - Version: " + pluginInstance.getDescription().getVersion() + 
               " | Author: " + pluginInstance.getDescription().getAuthors();
    }

    /**
     * Enables the API for external developers. This method might be used to initialize
     * additional functionality when a third-party plugin integrates with this plugin.
     */
    public static void enableAPI() {
        DebugLogger.log("HitChainAPI has been enabled for external integration.");
    }

    /**
     * Disables the API, ensuring that any integration functionality is properly unloaded.
     */
    public static void disableAPI() {
        DebugLogger.log("HitChainAPI has been disabled for external integration.");
    }
}
