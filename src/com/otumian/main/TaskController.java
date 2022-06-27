package com.otumian.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class TaskController {
    private final TaskRepository repository = new TaskRepository();

    public TaskController() {
        try {
            repository.createTable();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Could not create table");
        }
    }

    public void createTask() {
        try {
            Map<String, String> form = TaskView.createView();

            Task task = new Task();
            task.setTitle(form.get("title"));
            task.setDescription(form.get("description"));

            repository.save(task);

            System.out.println("Task created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Could not create task");
        }
    }

    public void readTask() {
        try {
            Map<String, Integer> form = TaskView.readView();

            int id = form.get("id");
            Task task = repository.findById(id);

            System.out.println(TaskView.printTask(task));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Could not read task");
        }
    }

    public void readAllTask() {
        try {
            ArrayList<Task> tasks = repository.findAll();

            for (Task task : tasks) {
                System.out.println(TaskView.printTask(task));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateTask() {

        try {
            Map<String, Object> form = TaskView.updateView();

            Task task = new Task();
            task.setId((int) form.get("id"));
            task.setTitle((String) form.get("title"));
            task.setDescription((String) form.get("description"));

            repository.update(task);

            System.out.println("Task updated successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Could not update task");
        }
    }

    public void deleteTask() {
        try {
            Map<String, Integer> form = TaskView.readView();

            int id = form.get("id");
            repository.deleteById(id);

            System.out.println("Task deleted successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Could not delete task");
        }
    }
}
