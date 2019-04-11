package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LibraryTests {
    private Library library;

    @Before
    public void setUp() {
        this.library = new Library();
    }

    @Test
    public void testWelcomeMessageShouldReturnMessage() {
        //Arrange
        String message = "Hello World!";
        //Act
        library.setWelcomeMessage(message);
        //Assert
        assertEquals("Hello World!", library.getWelcomeMessage());
    }

    @Test
    public void testGetAllBookTitlesShouldReturnListOfBookTitles() {
        //Act
        String[] books = library.getAllBookTitles();
        //Assert
        assertNotNull(books);
        assertEquals("Seven Languages in Seven Weeks", books[0]);
        assertEquals("Testing Extreme Programming", books[1]);
        assertEquals("Ubuntu Kung Fu", books[2]);
    }

    @Test
    public void testGetAllBooksShouldReturnListOfBooks() {
        //Act
        Book[] results = library.getAllBooks();
        //Assert
        assertEquals("Seven Languages in Seven Weeks", results[0].getTitle());
        assertEquals("Bruce A. Tate", results[0].getAuthor());
        assertEquals("2010", results[0].getPublicationDate());
        assertEquals("Testing Extreme Programming", results[1].getTitle());
        assertEquals("Lisa Crispin", results[1].getAuthor());
        assertEquals("2003", results[1].getPublicationDate());
        assertEquals("Ubuntu Kung Fu", results[2].getTitle());
        assertEquals("Keir Thomas", results[2].getAuthor());
        assertEquals("2008", results[2].getPublicationDate());
    }
}
