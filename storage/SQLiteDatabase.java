package com.hitchainapi.storage;

import java.sql.*;
import java.util.UUID;

public class SQLiteDatabase {

    private Connection connection;

    public SQLiteDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:plugins/HitChainAPI/data.db");
            initTables();
        } catch (Exception ignored) {}
    }

    private void initTables() {
        try (PreparedStatement ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS player_data (uuid TEXT, key TEXT, value TEXT, PRIMARY KEY(uuid, key))")) {
            ps.executeUpdate();
        } catch (SQLException ignored) {}
    }

    public void saveData(UUID uuid, String key, String value) {
        try (PreparedStatement ps = connection.prepareStatement("REPLACE INTO player_data(uuid, key, value) VALUES (?, ?, ?)")) {
            ps.setString(1, uuid.toString());
            ps.setString(2, key);
            ps.setString(3, value);
            ps.executeUpdate();
        } catch (SQLException ignored) {}
    }

    public String loadData(UUID uuid, String key) {
        try (PreparedStatement ps = connection.prepareStatement("SELECT value FROM player_data WHERE uuid = ? AND key = ?")) {
            ps.setString(1, uuid.toString());
            ps.setString(2, key);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getString("value");
        } catch (SQLException ignored) {}
        return null;
    }
}

