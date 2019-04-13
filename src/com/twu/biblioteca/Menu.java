package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.Scanner;

class Menu {
    private String menuOptionsMessage;
    private Library _library;

    Menu() {
        this.menuOptionsMessage = "Menu:\n\n";
        menuOptionsMessage += "1. Display a list of all books.\n";
        menuOptionsMessage += "2. Checkout a book.\n";
        menuOptionsMessage += "X. Exit Program.\n";

        this._library = new Library();
    }

    void start() {
        displayWelcomeMessage();
        displayMenuOptions();
    }

    private int readInput() {
        try {
            System.out.println("Enter number here:");
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            if(input.equals("x")) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
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
        int[] menuOptions = new int[] {0, 1, 2};
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
                printBookList(_library.getAllBooks());
                break;
            case 2:
                displayCheckOutBook();
                break;

        }
        displayMenuOptions();
    }

    private void displayCheckOutBook() {
        System.out.println("Here is a list of available books:\n\n");
        printBookList(_library.getAllBooks());
        int option = readInput();
        Book checkedOutBook = _library.getBook(option);
        _library.checkOutBook(checkedOutBook);
        System.out.println("Book #: " + option + " has been successfully checked out.");
    }

    private void printBookList(ArrayList<Book> books) {
        System.out.printf("%-35s %-25s %-35s \n\n", "Title", "Author", "Publication Date");
        for (Book book : books) {
            System.out.printf("%-5s %-35s %-25s %-35s \n", books.indexOf(book) + ".", book.getTitle(), book.getAuthor(), book.getPublicationDate());
        }
    }
}
