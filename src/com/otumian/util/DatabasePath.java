package com.otumian.util;

public class DatabasePath {
    private static final String root = "jdbc:sqlite:src/com/otumian/database/";

    public static String url(String dbName) {
        return root + dbName;
    }
}
