package com.otumian.tutorial;

import com.otumian.util.DatabaseConnection;
import com.otumian.util.DatabasePath;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
    public UpdateData() {

    }

    public static void main(String[] args) {
        UpdateData data = new UpdateData();

        data.updateTask(
                3,
                "The heart of Rock Lee",
                "Rock Lee is an inspirational character from the Naruto series"
        );

        data.updateTask(
                4,
                "michael birthday",
                "I would rather spend the day with kevin and talk software arch and design"
        );

        data.updateTask(
                5,
                "Anime time",
                "I would like to watch an isekai, demon and anti-hero anime"
        );
    }

    void updateTask(int id, String title, String description) {
        String url = DatabasePath.url("todoapp.db");
        Connection connection = DatabaseConnection.connection(url);

        String sql = "UPDATE task SET title=?, description=? WHERE id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, description);
            statement.setInt(3, id);

            statement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // throw new RuntimeException(e);
        }
    }
}
