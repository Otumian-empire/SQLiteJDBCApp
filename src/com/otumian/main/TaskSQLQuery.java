package com.otumian.main;

public class TaskSQLQuery {
    public static final String INSERT = "INSERT INTO task (title, description) VALUES(?, ?)";

    public static final String SELECT_ALL = "SELECT id, title, description FROM task";

    public static final String SELECT = "SELECT id, title, description FROM task WHERE id=?";

    public static final String UPDATE = "UPDATE task SET title=?, description=? WHERE id=?";

    public static final String DELETE = "DELETE FROM task WHERE id=?";
}
