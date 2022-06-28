package com.otumian.main;

import java.util.Scanner;

public class Main {
    public Main() {
        while (true) {
            indexPage();
            printPromptIndicator();

            int option = getOption();
            TaskController taskController = new TaskController();

            switch (option) {
                case ControllerOption.CREATE:
                    taskController.createTask();
                    break;
                case ControllerOption.SELECT_BY_ID:
                    taskController.readTask();
                    break;
                case ControllerOption.SELECT_ALL:
                    taskController.readAllTask();
                    break;
                case ControllerOption.UPDATE_BY_ID:
                    taskController.updateTask();
                    break;
                case ControllerOption.DELETE_BY_ID:
                    taskController.deleteTask();
                    break;
                default:
                    System.out.println("Exiting the program");
                    System.exit(0);
                    break;
            }

            waitForSomeSeconds();
            printManyNewlines();
        }
    }

    public static void main(String[] args) {
        new Main();
    }

    public int getOption() {
        Scanner scanner = new Scanner(System.in);
        int option = 6;

        try {
            option = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Please enter a valid option");
        }

        return option;
    }

    public void indexPage() {
        System.out.println("Todo App");
        System.out.println("--------\n");
        System.out.println("Choose a number to interact with the app.");
        System.out.println("1 - Create");
        System.out.println("2 - Select by ID");
        System.out.println("3 - Select all");
        System.out.println("4 - Update by ID");
        System.out.println("5 - Delete by ID");
        System.out.println("6 - Exit");
    }

    public void printPromptIndicator() {
        System.out.print("--> ");
    }

    public void printManyNewlines() {
        System.out.println("\n\n\n\n\n");
    }

    public void waitForSomeSeconds() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }
    }

    public static class ControllerOption {
        public static final int CREATE = 1;
        public static final int SELECT_BY_ID = 2;
        public static final int SELECT_ALL = 3;
        public static final int UPDATE_BY_ID = 4;
        public static final int DELETE_BY_ID = 5;
    }
}
