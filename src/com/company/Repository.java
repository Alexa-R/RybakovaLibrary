package com.company;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Repository {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/RybakovaLibrary?serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASS = "600591";

    private Connection connection;

    public Repository() throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Error while registering JDBC driver");
        }

        connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
    }

    /*public void create(Book book) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(
                "insert into employees value (null, ?, ?, ?);"
        );
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.executeUpdate();
    }*/

    public void showB() throws SQLException {

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT*FROM book");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");

            System.out.println("\n================\n");
            System.out.println("id: " + id);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    public void selectB(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT*FROM book WHERE id = ?;"
        );

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            System.out.println("\n================\n");
            System.out.println("id: " + id);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    public void getB(int id) throws IOException, SQLException {

        PreparedStatement statement = connection.prepareStatement(
                "delete from book where id = ?;"
        );

        statement.setInt(1, id);
        statement.execute();
    }

    public void returnB()
            throws IOException, SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into book values(null, ?,?);"
        );
        Scanner scan = new Scanner(System.in);
        System.out.println("Write a title");
        String title = scan.nextLine();
        System.out.println("Write an author");
        String author = scan.nextLine();


        preparedStatement.setString(1, title);
        preparedStatement.setString(2, author);
        preparedStatement.execute();

        System.out.println("New book:" );
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}
