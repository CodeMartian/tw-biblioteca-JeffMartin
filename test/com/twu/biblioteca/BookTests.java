package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTests {
    private Book book;

    @Before
    public void setUp() {
        this.book = new Book("Title", "Author", "2019");
    }

    @Test
    public void getTitleShouldReturnTitle() {
        //Act
        String result = book.getTitle();
        //Assert
        assertEquals("Title", result);
    }

    @Test
    public void getAuthorShouldReturnAuthor() {
        //Act
        String result = book.getAuthor();
        //Assert
        assertEquals("Author", result);
    }

    @Test
    public void getAuthorShouldReturnPublicationDate() {
        //Act
        String result = book.getPublicationDate();
        //Assert
        assertEquals("2019", result);
    }
}
