package com.company;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Repository repository;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        try {
            repository = new Repository();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {

            System.out.println("Hello! Write S to start.");
            input = scan.nextLine();
            System.out.println("You are in program!");
            while (!"E".equals(input)) {
                System.out.println("What do you want to do?" +
                        "\n1 - See all books;" +
                        "\n2 - Select book;" +
                        "\n3 - Delete book;" +
                        "\n4 - Add book;" +
                        "\nE - Exit.");
                input = scan.nextLine();
                switch (input) {
                    case "1":
                        showAllBooks();
                        break;
                    case "2":
                        selectBook();
                        break;
                    case "3":
                        getBook();
                        break;
                    case "4":
                        returnBook();
                        break;
                }
                System.out.println("\nDo you want to continue?" +
                        "\n      Yes - to continue" +
                        "\n      E - to exit");
                input = scan.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQLException");
        }
    }

    private static void showAllBooks() throws SQLException {
        repository.showB();
    }

    private static void selectBook() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an id of the book");
        int id = scan.nextInt();
        repository.selectB(id);
    }

    private static void getBook() throws IOException, SQLException {

        System.out.println("Enter id");
        Scanner scan = new Scanner(System.in);
        int id = Integer.parseInt(scan.next());
        repository.getB(id);
        System.out.println("The book is deleted.");
    }
    private static void returnBook() throws IOException, SQLException {
        repository.returnB();

    }
}
