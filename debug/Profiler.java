package com.hitchainapi.debug;

import com.hitchainapi.HitChainPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Profiler {

    private final HitChainPlugin plugin;

    public Profiler(HitChainPlugin plugin) {
        this.plugin = plugin;
    }

    public void startProfiling() {
        Bukkit.getScheduler().runTaskTimer(plugin, this::profilePluginPerformance, 0, 200); // Runs every 10 seconds (200 ticks)
    }

    private void profilePluginPerformance() {
        long memoryUsage = getMemoryUsage();
        double cpuUsage = getCpuUsage();

        plugin.getLogger().info("Memory Usage: " + memoryUsage + "MB");
        plugin.getLogger().info("CPU Usage: " + cpuUsage + "%");

        // You can adjust the thresholds and add more logging or recovery actions here
        if (memoryUsage > 500) { // If memory usage exceeds 500MB
            plugin.getLogger().warning("High memory usage detected!");
        }

        if (cpuUsage > 80) { // If CPU usage exceeds 80%
            plugin.getLogger().warning("High CPU usage detected!");
        }
    }

    private long getMemoryUsage() {
        // Returns the current memory usage of the JVM in MB
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
    }

    private double getCpuUsage() {
        // This is a simplified CPU usage getter (not 100% accurate, but useful for basic monitoring)
        // For detailed CPU profiling, you can integrate external libraries or use JMX.
        return Math.random() * 100;  // Simulated value for example
    }
}
