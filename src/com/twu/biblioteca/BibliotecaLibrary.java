package com.twu.biblioteca;

public class BibliotecaLibrary {
    private String welcomeMessage;
    private Book[] books;

    public BibliotecaLibrary() {
        books = new Book[3];
        books[0] = new Book("Seven Languages in Seven Weeks");
        books[1] = new Book("Testing Extreme Programming");
        books[2] = new Book("Ubuntu Kung Fu");
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String message) {
        this.welcomeMessage = message;
    }

    public String[] listAllBooks() {
        String[] bookList = new String[books.length];

        for (int x = 0; x < books.length; x++){
            bookList[x] = books[x].getTitle();
        }

        return bookList;
    }
}
