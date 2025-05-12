package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import storage.DataManager;
import storage.SQLiteDatabase;
import storage.RedisDatabase;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import static org.junit.Assert.*;

public class StorageTests {

    private DataManager dataManager;
    private SQLiteDatabase sqlite;
    private RedisDatabase redis;

    @Before
    public void setup() {
        sqlite = new SQLiteDatabase(new File("test.db"));
        sqlite.connect();
        dataManager = new DataManager(sqlite);
        redis = new RedisDatabase("localhost", 6379);
    }

    @After
    public void cleanup() {
        sqlite.disconnect();
        File dbFile = new File("test.db");
        if (dbFile.exists()) dbFile.delete();
    }

    @Test
    public void testSQLiteConnection() {
        Connection conn = sqlite.getConnection();
        assertNotNull(conn);
        try {
            assertFalse(conn.isClosed());
        } catch (SQLException e) {
            fail("Connection should not be closed");
        }
    }

    @Test
    public void testSQLiteInsertAndLoad() {
        UUID uuid = UUID.randomUUID();
        String name = "TestPlayer";
        dataManager.savePlayerData(uuid, name, 10, 50);
        assertEquals(10, dataManager.getPlayerKills(uuid));
        assertEquals(50, dataManager.getPlayerCoins(uuid));
    }

    @Test
    public void testRedisConnection() {
        assertTrue(redis.isConnected());
    }

    @Test
    public void testRedisSetGet() {
        UUID uuid = UUID.randomUUID();
        redis.save(uuid, "coins", 100);
        int coins = redis.get(uuid, "coins");
        assertEquals(100, coins);
    }

    @Test
    public void testRedisBulkData() {
        UUID uuid = UUID.randomUUID();
        for (int i = 0; i < 50; i++) redis.save(uuid, "stat_" + i, i);
        for (int i = 0; i < 50; i++) {
            int val = redis.get(uuid, "stat_" + i);
            assertEquals(i, val);
        }
    }
}

