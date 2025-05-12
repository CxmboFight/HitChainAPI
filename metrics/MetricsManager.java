package com.hitchainapi.metrics;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class MetricsManager {

    private final Metrics metrics;
    private final Plugin plugin;

    public MetricsManager(Plugin plugin, int pluginId) {
        this.plugin = plugin;
        this.metrics = new Metrics(plugin, pluginId);
        registerDefaultCharts();
    }

    private void registerDefaultCharts() {
        metrics.addCustomChart(new Metrics.SingleLineChart("players_online", () -> plugin.getServer().getOnlinePlayers().size()));

        metrics.addCustomChart(new Metrics.SimplePie("server_version", () -> plugin.getServer().getVersion()));

        metrics.addCustomChart(new Metrics.SimplePie("java_version", () -> System.getProperty("java.version")));

        metrics.addCustomChart(new Metrics.AdvancedPie("player_distribution", () -> {
            Map<String, Integer> map = new HashMap<>();
            int count = plugin.getServer().getOnlinePlayers().size();
            map.put("Online", count > 0 ? count : 1);
            return map;
        }));
    }

    public void trackCustomMetric(String chartId, int value) {
        metrics.addCustomChart(new Metrics.SingleLineChart(chartId, () -> value));
    }

    public void trackPieMetric(String chartId, String value) {
        metrics.addCustomChart(new Metrics.SimplePie(chartId, () -> value));
    }

    public void trackAdvancedMetric(String chartId, Map<String, Integer> data) {
        metrics.addCustomChart(new Metrics.AdvancedPie(chartId, () -> data));
    }

    public Metrics getMetricsInstance() {
        return metrics;
    }
}

