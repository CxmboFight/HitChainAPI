package com.hitchainapi.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DebugLogger {

    private static final Logger LOGGER = Logger.getLogger(DebugLogger.class.getName());
    private static boolean debugModeEnabled = true;

    /**
     * Enable or disable debug mode globally.
     * @param enabled true to enable, false to disable.
     */
    public static void setDebugModeEnabled(boolean enabled) {
        debugModeEnabled = enabled;
    }

    /**
     * Log a debug message.
     * @param message The message to log.
     */
    public static void debug(String message) {
        if (debugModeEnabled) {
            LOGGER.log(Level.INFO, "[DEBUG] " + message);
        }
    }

    /**
     * Log an error message.
     * @param message The message to log.
     */
    public static void error(String message) {
        LOGGER.log(Level.SEVERE, "[ERROR] " + message);
    }

    /**
     * Log a warning message.
     * @param message The message to log.
     */
    public static void warn(String message) {
        LOGGER.log(Level.WARNING, "[WARNING] " + message);
    }

    /**
     * Log a general info message.
     * @param message The message to log.
     */
    public static void info(String message) {
        LOGGER.log(Level.INFO, "[INFO] " + message);
    }

    /**
     * Log a fatal error and exit the application.
     * @param message The message to log.
     */
    public static void fatal(String message) {
        LOGGER.log(Level.SEVERE, "[FATAL] " + message);
        System.exit(1);  // Exits the application with an error code
    }
}

