package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidInputException;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

class Menu {
    private String menuOptionsMessage;
    private Library _library;
    private PrintStream printStream;
    private Scanner scanner;

    Menu(PrintStream printStream, Scanner scanner) {
        this.menuOptionsMessage = "Menu:\n\n";
        menuOptionsMessage += "1. Display a list of all books.\n";
        menuOptionsMessage += "2. Checkout a book.\n";
        menuOptionsMessage += "3. Return a book.\n";
        menuOptionsMessage += "X. Exit Program.\n";

        this._library = new Library();
        this.printStream = printStream;
        this.scanner = scanner;
    }

    void start() {
        displayWelcomeMessage();
        displayMenuOptions();
    }

    private String readInput() {
            printStream.println("Enter input here:");
            String input = scanner.nextLine();
            if(input.equals("x")) {
                printStream.println("Goodbye!");
                System.exit(0);
            }
            return input;
    }

    private void displayMenuOptions() {
        String readInput;
        printStream.println(this.menuOptionsMessage);

        try {
            readInput = readInput();
            validateInput(readInput);
            selectOption(readInput);
        } catch (InvalidInputException e) {
            printStream.println(e.getMessage());
            displayMenuOptions();
        }
    }

    public void displayWelcomeMessage() {
        printStream.println("Welcome to Biblioteca! Your one-stop-shop for books in Bangalore!");
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
            printBookList(_library.getAllBooks());
        } else if ("2".equals(input)) {
            displayCheckOutBook();
        } else if ("3".equals(input)){
            displayReturnOption();
        }
        displayMenuOptions();
    }

    private void displayReturnOption() {
        printStream.println("Please enter the title of the book you would like to return.");
        String input = readInput();
        printStream.println(_library.returnBook(input));
    }

    private void displayCheckOutBook() {
        printStream.println("Here is a list of available books:\n\n");
        printBookList(_library.getAvailableBooks());
        String option = readInput();
        String result = _library.checkOutBook(option);
        printStream.println(result);
    }

    private void printBookList(ArrayList<Book> books) {
        printStream.printf("%-5s %-35s %-25s %-35s \n\n", "", "Title", "Author", "Publication Date");
        for (Book book : books) {
            printStream.printf("%-5s %-35s %-25s %-35s \n", books.indexOf(book) + ".", book.getTitle(), book.getAuthor(), book.getPublicationDate());
        }
    }
}
