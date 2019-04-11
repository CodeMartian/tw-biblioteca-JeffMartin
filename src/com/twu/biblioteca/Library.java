package com.twu.biblioteca;

public class Library {
    private String welcomeMessage;
    private Book[] books;

    public Library() {
        books = new Book[3];
        books[0] = new Book("Seven Languages in Seven Weeks", "Bruce A. Tate", "2010");
        books[1] = new Book("Testing Extreme Programming", "Lisa Crispin", "2003");
        books[2] = new Book("Ubuntu Kung Fu", "Keir Thomas", "2008");
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public Book[] getAllBooks() {
        return books;
    }

    public void setWelcomeMessage(String message) {
        this.welcomeMessage = message;
    }

    public String[] getAllBookTitles() {
        String[] bookTitles = new String[books.length];

        for (int x = 0; x < books.length; x++){
            bookTitles[x] = books[x].getTitle();
        }

        return bookTitles;
    }
}
