package com.hitchainapi.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CooldownManager {

    private final Map<UUID, Map<String, Long>> playerCooldowns;

    public CooldownManager() {
        playerCooldowns = new HashMap<>();
    }

    /**
     * Start a cooldown for a player.
     * @param playerUUID The player's UUID.
     * @param action The action being cooled down (e.g., "ability", "command").
     * @param cooldownTime The cooldown time in milliseconds.
     */
    public void startCooldown(UUID playerUUID, String action, long cooldownTime) {
        if (!playerCooldowns.containsKey(playerUUID)) {
            playerCooldowns.put(playerUUID, new HashMap<>());
        }
        
        Map<String, Long> cooldowns = playerCooldowns.get(playerUUID);
        cooldowns.put(action, System.currentTimeMillis() + cooldownTime);
    }

    /**
     * Check if a player is on cooldown for a specific action.
     * @param playerUUID The player's UUID.
     * @param action The action being checked.
     * @return True if the player is still on cooldown, false otherwise.
     */
    public boolean isOnCooldown(UUID playerUUID, String action) {
        if (!playerCooldowns.containsKey(playerUUID)) {
            return false;
        }
        
        Map<String, Long> cooldowns = playerCooldowns.get(playerUUID);
        if (!cooldowns.containsKey(action)) {
            return false;
        }

        long cooldownEndTime = cooldowns.get(action);
        return System.currentTimeMillis() < cooldownEndTime;
    }

    /**
     * Get the remaining time for a player's cooldown.
     * @param playerUUID The player's UUID.
     * @param action The action being checked.
     * @return The remaining cooldown time in milliseconds.
     */
    public long getRemainingCooldown(UUID playerUUID, String action) {
        if (!playerCooldowns.containsKey(playerUUID)) {
            return 0;
        }

        Map<String, Long> cooldowns = playerCooldowns.get(playerUUID);
        if (!cooldowns.containsKey(action)) {
            return 0;
        }

        long cooldownEndTime = cooldowns.get(action);
        return Math.max(0, cooldownEndTime - System.currentTimeMillis());
    }

    /**
     * Remove a specific cooldown for a player.
     * @param playerUUID The player's UUID.
     * @param action The action whose cooldown will be removed.
     */
    public void removeCooldown(UUID playerUUID, String action) {
        if (playerCooldowns.containsKey(playerUUID)) {
            Map<String, Long> cooldowns = playerCooldowns.get(playerUUID);
            cooldowns.remove(action);
        }
    }

    /**
     * Clear all cooldowns for a player.
     * @param playerUUID The player's UUID.
     */
    public void clearCooldowns(UUID playerUUID) {
        playerCooldowns.remove(playerUUID);
    }
}

