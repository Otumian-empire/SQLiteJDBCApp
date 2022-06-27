package com.otumian.main;

import com.otumian.util.DatabaseConnection;
import com.otumian.util.DatabasePath;

import java.sql.*;
import java.util.ArrayList;

public class TaskRepository {
    final private String db = "main.db";
    private final String url = DatabasePath.url(db);

    public void save(Task task) throws SQLException {
        Connection connection = DatabaseConnection.connection(url);

        PreparedStatement statement = connection.prepareStatement(TaskSQLQuery.INSERT);
        statement.setString(1, task.getTitle());
        statement.setString(2, task.getDescription());
        statement.executeUpdate();

        connection.close();
    }

    public Task findById(int id) throws SQLException {
        Connection connection = DatabaseConnection.connection(url);

        PreparedStatement statement = connection.prepareStatement(TaskSQLQuery.SELECT);
        statement.setInt(1, id);

        ResultSet result = statement.executeQuery();
        int resultId = result.getInt("id");
        String resultTitle = result.getString("title");
        String resultDescription = result.getString("description");

        connection.close();

        return new Task(resultId, resultTitle, resultDescription);
    }

    public ArrayList<Task> findAll() throws SQLException {
        Connection connection = DatabaseConnection.connection(url);
        Statement statement = connection.createStatement();

        ArrayList<Task> tasks = new ArrayList<>();

        ResultSet results = statement.executeQuery(TaskSQLQuery.SELECT_ALL);

        while (results.next()) {
            int resultId = results.getInt("id");
            String resultTitle = results.getString("title");
            String resultDescription = results.getString("description");

            tasks.add(new Task(resultId, resultTitle, resultDescription));
        }

        connection.close();

        return tasks;
    }

    // get id from the object passed
    public void update(Task task) throws SQLException {
        Connection connection = DatabaseConnection.connection(url);

        PreparedStatement statement = connection.prepareStatement(TaskSQLQuery.UPDATE);
        statement.setString(1, task.getTitle());
        statement.setString(2, task.getDescription());
        statement.setInt(3, task.getId());
        statement.executeUpdate();

        connection.close();
    }

    public void deleteById(int id) throws SQLException {
        Connection connection = DatabaseConnection.connection(url);

        PreparedStatement statement = connection.prepareStatement(TaskSQLQuery.DELETE);
        statement.setInt(1, id);
        statement.executeUpdate();

        connection.close();
    }

    public void createTable() throws SQLException {
        try {
            Connection connection = DatabaseConnection.connection(url);

            Statement statement = connection.createStatement();
            statement.execute(TaskSQLQuery.CREATE_TABLE());

            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
