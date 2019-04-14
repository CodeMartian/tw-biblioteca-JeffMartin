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

    public String checkOutBook(String bookTitle) {

        for(Book book: books) {
            if (book.getTitle().equals(bookTitle) && !book.isCheckedOut()){
                book.setCheckedOut();
                return "Thank you! You have successfully checked out '" + book.getTitle() + "'";
            }
        }
        return "Sorry, this book is not available.";
    }

    public Book getBook(int i) {
        return books.get(i);
    }

    public ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        for (Book book: books) {
            if (!book.isCheckedOut()){
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public void returnBook(String bookReturn) {
        for(Book book : books){
            if (book.getTitle().equals(bookReturn)) {
                book.setReturned();
            }
        }
    }
}
