package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.Scanner;

class Menu {
    private String menuOptionsMessage;
    private Library library;

    Menu() {
        this.menuOptionsMessage = "Menu:\n\n";
        menuOptionsMessage += "1. Display a list of all books.\n";
        menuOptionsMessage += "2. Checkout a book.\n";
        menuOptionsMessage += "3. Return a book.\n";
        menuOptionsMessage += "X. Exit Program.\n";

        this.library = new Library();
    }

    void start() {
        displayWelcomeMessage();
        displayMenuOptions();
    }

    private String readInput() {
            System.out.println("Enter input here:");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if(input.equals("x")) {
                quit();
            }
            return input;
    }

    private void quit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }

    private void displayMenuOptions() {
        System.out.println(this.menuOptionsMessage);
        String readInput = readInput();
        try {
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
        String[] menuOptions = {"0", "1", "2", "3"};
        for (String option : menuOptions) {
            if (input.equals(option)) {
                return;
            }
        }
        throw new InvalidInputException();
    }

    private void selectOption(String input) {
        if ("1".equals(input)) {
            printBookList(library.getAllBooks());
        } else if ("2".equals(input)) {
            displayCheckOutBook();
        } else if ("3".equals(input)){
            displayReturnOption();
        }
        displayMenuOptions();
    }

    private void displayReturnOption() {
        System.out.println("Please enter the title of the book you would like to return.");
        System.out.println(library.returnBook(readInput()));
    }

    private void displayCheckOutBook() {
        System.out.println("Here is a list of available books:\n\n");
        printBookList(library.getAvailableBooks());
        System.out.println(library.checkOutBook(readInput()));
    }

    private void printBookList(ArrayList<Book> books) {
        System.out.printf("%-5s %-35s %-25s %-35s \n\n", "", "Title", "Author", "Publication Date");
        for (Book book : books) {
            System.out.printf("%-5s %-35s %-25s %-35s \n", books.indexOf(book) + ".", book.getTitle(), book.getAuthor(), book.getPublicationDate());
        }
    }
}
