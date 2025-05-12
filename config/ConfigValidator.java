package com.hitchainapi.config;

public class ConfigValidator {

    public static boolean validate(ConfigManager configManager) {
        boolean valid = true;

        if (configManager.getConfigLoader().get(ConfigDefaults.SOME_SETTING) == null) {
            configManager.getConfigLoader().set(ConfigDefaults.SOME_SETTING, "defaultValue");
            valid = false;
        }
        if (configManager.getConfigLoader().get(ConfigDefaults.ENABLE_FEATURE_X) == null) {
            configManager.getConfigLoader().set(ConfigDefaults.ENABLE_FEATURE_X, true);
            valid = false;
        }
        if (configManager.getConfigLoader().get(ConfigDefaults.DATABASE_URL) == null) {
            configManager.getConfigLoader().set(ConfigDefaults.DATABASE_URL, "jdbc:mysql://localhost:3306/hitchain");
            valid = false;
        }
        return valid;
    }
}
