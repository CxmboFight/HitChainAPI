package com.hitchainapi.storage;

import java.util.UUID;

public class DataManager {

    private final SQLiteDatabase sqlite;
    private final RedisDatabase redis;
    private final CloudStorageManager cloud;

    public DataManager() {
        this.sqlite = new SQLiteDatabase();
        this.redis = new RedisDatabase();
        this.cloud = new CloudStorageManager();
    }

    public void savePlayerData(UUID uuid, String key, String value) {
        sqlite.saveData(uuid, key, value);
        redis.cacheData(uuid, key, value);
        cloud.backupData(uuid, key, value);
    }

    public String loadPlayerData(UUID uuid, String key) {
        String cached = redis.getCachedData(uuid, key);
        if (cached != null) return cached;
        return sqlite.loadData(uuid, key);
    }

    public void flushAll() {
        redis.flushCacheToDisk(sqlite);
    }
}

