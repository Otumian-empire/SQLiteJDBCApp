package com.otumian.tutorial;

import com.otumian.util.DatabaseConnection;
import com.otumian.util.DatabasePath;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
    public DeleteData() {
    }

    public static void main(String[] args) {
        DeleteData data = new DeleteData();

        data.deleteTask(3);

        data.deleteTask(4);

        data.deleteTask(5);
    }

    void deleteTask(int id) {
        String url = DatabasePath.url("todoapp.db");
        Connection connection = DatabaseConnection.connection(url);

        String sql = "DELETE FROM task WHERE id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // throw new RuntimeException(e);
        }
    }
}
