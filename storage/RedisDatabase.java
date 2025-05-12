package com.hitchainapi.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RedisDatabase {

    private final Map<UUID, Map<String, String>> cache = new HashMap<>();

    public void cacheData(UUID uuid, String key, String value) {
        cache.computeIfAbsent(uuid, k -> new HashMap<>()).put(key, value);
    }

    public String getCachedData(UUID uuid, String key) {
        Map<String, String> data = cache.get(uuid);
        if (data == null) return null;
        return data.get(key);
    }

    public void flushCacheToDisk(SQLiteDatabase sqlite) {
        for (Map.Entry<UUID, Map<String, String>> entry : cache.entrySet()) {
            UUID uuid = entry.getKey();
            for (Map.Entry<String, String> sub : entry.getValue().entrySet()) {
                sqlite.saveData(uuid, sub.getKey(), sub.getValue());
            }
        }
        cache.clear();
    }
}

