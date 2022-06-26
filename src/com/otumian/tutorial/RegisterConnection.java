package com.otumian.tutorial;

import com.otumian.util.DatabasePath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To connect to a database we need the SQLite connection which will be in the
 * 'jdbc:sqlite:path_to_sqlite_db' or 'jdbc:sqlite::memory' to use the in-memory
 * database. For this, we would create a database for a 'todoapp'.
 *
 *
 * We would have to download the 'SQLite JDBC Driver' from the link below
 * https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc
 *
 * Add the downloaded jar file to your current application. In IntelliJ:
 * - Click on File, then Project Structure
 * - Under Project Settings, click on Libraries
 * - Add a new library (jar file) by clicking on the '+'
 * - Select 'java' from the dropdown and navigator to the path where the
 *    'SQLite JDBC Driver' is located and choose it (It has a '.jar' extension)
 * - Click apply then okay. It will appear alongside the External Libraries
 * */
public class RegisterConnection {
    public RegisterConnection() {
        // Get connection from the DriverManager from 'java.sql' package
        // It returns a connection of type Connection also from 'java.sql' package
        // final String url = "jdbc:sqlite:src/com/otumian/database/todoapp.db";

        // Now let's make use of the Utility that we have created
        // all that we need to do is pass the database name
        final String url = DatabasePath.url("todoapp.db");

        try {
            Connection connection = DriverManager.getConnection(url);

            if (connection != null) {
                // from here we can do anything we want to the connection
                // we have to close the database resource after use
                System.out.println("We have a database connection");
                connection.close();
            } else {
                throw new SQLException("The connection was null");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new RegisterConnection();
    }
}

/*
 * Since this will be a long sweet journey, let's create a folder for the databases
 * that we will create and gitignore them. Alter the url string and add the folder name
 * to it. Like so: 'final String url = "jdbc:sqlite:database/todoapp.db";'
 * Create the folder and Now run the app again with Ctrl+F5. On success delete the old
 * todoapp database file.
 *
 * There could be issues like the path can't be found. Make sure to create the folder manually
 * then enter the path properly
 *
 * Looking at how lazy we are we can create an util method to set the database path
 *  */


