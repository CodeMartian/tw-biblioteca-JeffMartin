package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> checkedInBooks;
    private ArrayList<Book> checkedOutBooks;
    private ArrayList<Movie> checkedInMovies;
    private ArrayList<Movie> checkedOutMovies;

    public Library() {
        checkedInBooks = new ArrayList<Book>();
        checkedOutBooks = new ArrayList<Book>();
        checkedInBooks.add(new Book("Seven Languages in Seven Weeks", "Bruce A. Tate", "2010"));
        checkedInBooks.add(new Book("Testing Extreme Programming", "Lisa Crispin", "2003"));
        checkedInBooks.add(new Book("Ubuntu Kung Fu", "Keir Thomas", "2008"));

        checkedInMovies = new ArrayList<Movie>();
        checkedOutMovies = new ArrayList<Movie>();
        checkedInMovies.add(new Movie("Fantastic Beasts and Where To Find Them"));
        checkedInMovies.add(new Movie("Mary Poppins"));
        checkedInMovies.add(new Movie("Mortal Engines"));
    }

    public String checkOutBook(String bookTitle) {

        for(Book book: checkedInBooks) {
            if (book.getTitle().equals(bookTitle)){
                checkedOutBooks.add(book);
                checkedInBooks.remove(book);
                return "Thank you! You have successfully checked out '" + book.getTitle() + "'";
            }
        }
        return "Sorry, this book is not available.";
    }

    public Book getBook(int i) {
        return checkedInBooks.get(i);
    }

    public ArrayList<Book> getAvailableBooks() {
        return checkedInBooks;
    }

    public String returnBook(String bookReturn) {
        for(Book book : checkedOutBooks){
            if (book.getTitle().equals(bookReturn)) {
                checkedInBooks.add(book);
                checkedOutBooks.remove(book);
                return "Thank you! You have successfully returned '" + bookReturn + "'";
            }
        }
        return "I'm sorry. The book you entered does not belong to this library.";
    }

    public String checkOutMovie(String title) {
        for(Movie movie : checkedInMovies) {
            if(movie.getTitle().equals(title)){
                checkedOutMovies.add(movie);
                checkedInMovies.remove(movie);
                return "Thank you! You have successfully checked out '" + title + "'";
            }
        }
        return "I'm sorry. The book you entered does not belong to this library.";
    }

    public ArrayList<Movie> getAvailableMovies() {
        return checkedInMovies;
    }
}
