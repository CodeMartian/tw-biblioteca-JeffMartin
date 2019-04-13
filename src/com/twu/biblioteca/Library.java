package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private String welcomeMessage;
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<Book>();
        books.add(new Book("Seven Languages in Seven Weeks", "Bruce A. Tate", "2010"));
        books.add(new Book("Testing Extreme Programming", "Lisa Crispin", "2003"));
        books.add(new Book("Ubuntu Kung Fu", "Keir Thomas", "2008"));
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public ArrayList<Book> getAllBooks() {
        return books;
    }

    public void setWelcomeMessage(String message) {
        this.welcomeMessage = message;
    }

    public void checkOutBook(Book book) {
        books.remove(book);
    }

    public Book getBook(int i) {
        return books.get(i);
    }
}
