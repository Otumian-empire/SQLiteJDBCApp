package com.otumian.tutorial;

import com.otumian.util.DatabaseConnection;
import com.otumian.util.DatabasePath;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectData {

    public SelectData() {
        String url = DatabasePath.url("todoapp.db");
        Connection connection = DatabaseConnection.connection(url);

        String sql = "SELECT id, title, description FROM task";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            printResult(resultSet);


            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new SelectData();
    }

    public void printResult(ResultSet results) {
        while (true) {
            try {
                if (!results.next()) break;

                System.out.println(structureResult(results));
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                // throw new RuntimeException(e);
            }
        }
    }

    private String structureResult(ResultSet row) throws SQLException {
        return "Task(" + row.getInt("id") + ")\n" +
                "-----------------------\n" +
                row.getString("title") + "\n" +
                row.getString("description") + "\n";
    }


}
