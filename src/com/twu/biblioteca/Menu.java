package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    private String readInput() {
            System.out.println("Enter number here:");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if(input.equals("x")) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            return input;
    }

    private void displayMenuOptions() {
        String readInput;
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

    void validateInput(String input) throws InvalidInputException {
        List<String> menuOptions = Arrays.asList("0", "1", "2");
        if (!menuOptions.contains(input)) {
            throw new InvalidInputException();
        }
    }

    private void selectOption(String input) {
        if ("1".equals(input)) {
            printBookList(_library.getAllBooks());
        } else if ("2".equals(input)) {
            displayCheckOutBook();
        }
        displayMenuOptions();
    }

    private void displayCheckOutBook() {
        System.out.println("Here is a list of available books:\n\n");
        printBookList(_library.getAllBooks());
        String option = readInput();
        //TODO: Get book by title, not by index.
        String result = _library.checkOutBook(option);
        System.out.println(result);
    }

    private void printBookList(ArrayList<Book> books) {
        System.out.printf("%-5s %-35s %-25s %-35s \n\n", "", "Title", "Author", "Publication Date");
        for (Book book : books) {
            //TODO: Remove index selectors.
            System.out.printf("%-5s %-35s %-25s %-35s \n", books.indexOf(book) + ".", book.getTitle(), book.getAuthor(), book.getPublicationDate());
        }
    }
}
