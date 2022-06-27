package com.otumian.main;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskView {

    public static Map<String, String> createView() {
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

    public static Map<String, Integer> readView() {
        Map<String, Integer> input = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter id: ");
        int id = scanner.nextInt();

        input.put("id", id);

        scanner.close();

        return input;
    }

    public static Map<String, Object> updateView() {
        Map<String, Object> input = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter id: ");
        int id = scanner.nextInt();

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        input.put("id", id);
        input.put("title", title);
        input.put("description", description);

        scanner.close();

        return input;
    }

    public static String printTask(Task task) throws SQLException {
        return "Task(" + task.getId() + ")\n" +
                "-----------------------\n" +
                task.getTitle() + "\n" +
                task.getDescription() + "\n";
    }
}
