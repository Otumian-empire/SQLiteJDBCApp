package com.otumian.tutorial;

import com.otumian.util.DatabaseConnection;
import com.otumian.util.DatabasePath;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InsertData {

    public static void main(String[] args) {
        String url = DatabasePath.url("todoapp.db");
        Connection connection = DatabaseConnection.connection(url);

        String sql = "INSERT INTO task (title, description) VALUES(?, ?)";

        InsertData data = new InsertData();
        Map<String, String> map = data.getUserInput();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, map.get("title"));
            statement.setString(2, map.get("description"));

            int res = statement.executeUpdate();
            System.out.println("res: " + res);

            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
             // throw new RuntimeException(e);
        }
    }

    public Map<String, String> getUserInput() {
        Map<String, String> input = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        input.put("title", title);
        input.put("description", description);

        scanner.close();

        return input;
    }
}