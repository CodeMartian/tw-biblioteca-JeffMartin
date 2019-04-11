package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidInputException;

import java.util.Scanner;

class Menu {
    private String menuOptionsMessage;
    private Library _library;

    Menu() {
        this.menuOptionsMessage = "Menu:\n\n";
        menuOptionsMessage += "1. Display a list of all books.\n";
        menuOptionsMessage += "0. Exit Program.\n";

        this._library = new Library();
    }

    void start() {
        displayWelcomeMessage();
        displayMenuOptions();
    }

    private int readInput() {
        try {
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Oops! That's not a number! Please try again.\n");
            readInput();
        }
        return 0;
    }

    private void displayMenuOptions() {
        int readInput;
        System.out.println(this.menuOptionsMessage);

        try {
            readInput = readInput();
            validateInput(readInput);
            selectOption(readInput);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            displayMenuOptions();
        }
    }

    private void displayWelcomeMessage() {
        System.out.println("Welcome to Biblioteca! Your one-stop-shop for books in Bangalore!");
    }

    void validateInput(int input) throws InvalidInputException {
        int[] menuOptions = new int[] {0, 1};
        for (int option : menuOptions) {
            if (input == option) {
                return;
            }
        }
        throw new InvalidInputException();
    }

    private void selectOption(int input) {
        switch (input) {
            case 1:
                System.out.printf("%-35s %-25s %-35s \n\n", "Title", "Author", "Publication Date");

                for (Book book : _library.getAllBooks()) {
                    System.out.printf("%-35s %-25s %-35s \n", book.getTitle(), book.getAuthor(), book.getPublicationDate());
                }
                break;
            case 0:
                System.out.println("Goodbye!");
                System.exit(0);

        }
        displayMenuOptions();
    }
}
