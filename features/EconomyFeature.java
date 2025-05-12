package com.hitchainapi.features;

import com.hitchainapi.HitChainPlugin;
import org.bukkit.entity.Player;

public class EconomyFeature {

    private final HitChainPlugin plugin;

    public EconomyFeature(HitChainPlugin plugin) {
        this.plugin = plugin;
    }

    public void givePlayerMoney(Player player, double amount) {
        // Add the given amount to the player's balance
        double newBalance = getPlayerBalance(player) + amount;
        setPlayerBalance(player, newBalance);
        player.sendMessage("You have received " + amount + " money. New balance: " + newBalance);
    }

    public void subtractPlayerMoney(Player player, double amount) {
        // Subtract the given amount from the player's balance
        double newBalance = getPlayerBalance(player) - amount;
        if (newBalance < 0) {
            player.sendMessage("You don't have enough money!");
        } else {
            setPlayerBalance(player, newBalance);
            player.sendMessage("You have lost " + amount + " money. New balance: " + newBalance);
        }
    }

    public double getPlayerBalance(Player player) {
        // Placeholder for retrieving player's balance (could be from a database or in-memory store)
        // Example return value: returning a default value of 100 for simplicity
        return 100.0;
    }

    public void setPlayerBalance(Player player, double balance) {
        // Placeholder for setting player's balance (could update in a database or in-memory store)
        // In a real scenario, you would save this balance somewhere persistent.
    }
}

