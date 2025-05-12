package com.hitchainapi.config;

public class ConfigDefaults {

    public static final String SOME_SETTING = "someSetting";
    public static final String ENABLE_FEATURE_X = "enableFeatureX";
    public static final String DATABASE_URL = "database.url";
    public static final String MAX_PLAYERS = "maxPlayers";
    
    public static void setDefaults(ConfigManager configManager) {
        configManager.getConfigLoader().set(SOME_SETTING, "defaultValue");
        configManager.getConfigLoader().set(ENABLE_FEATURE_X, true);
        configManager.getConfigLoader().set(DATABASE_URL, "jdbc:mysql://localhost:3306/hitchain");
        configManager.getConfigLoader().set(MAX_PLAYERS, 100);
    }
}
