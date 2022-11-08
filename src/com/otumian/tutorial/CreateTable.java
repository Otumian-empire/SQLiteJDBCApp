package com.otumian.tutorial;

import com.otumian.util.DatabasePath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {

        String url = DatabasePath.url("todoapp.db");

        String sql = "CREATE TABLE IF NOT EXISTS \"task\" (";
        sql += "\"id\" INTEGER,";
        sql += "\"title\" TEXT NOT NULL,";
        sql += "\"description\"	TEXT,";
        sql += "PRIMARY KEY(\"id\" AUTOINCREMENT));";

        try {
            Connection conn = DriverManager.getConnection(url);

            if (conn != null) {
                Statement statement = conn.createStatement();

                statement.execute(sql);
                conn.commit();
                conn.close();

            } else {
                throw new SQLException("Connection was null");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
