package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BibliotecaLibraryTests {
    private BibliotecaLibrary bibliotecaLibrary;

    @Before
    public void setUp() {
        this.bibliotecaLibrary = new BibliotecaLibrary();
    }

    @Test
    public void testWelcomeMessageShouldReturnMessage() {
        //Arrange
        String message = "Hello World!";
        //Act
        bibliotecaLibrary.setWelcomeMessage(message);
        //Assert
        assertEquals("Hello World!", bibliotecaLibrary.getWelcomeMessage());
    }

    @Test
    public void testListBooksShouldReturnListOfBooks() {
        //Act
        String[] books = bibliotecaLibrary.listAllBooks();
        //Assert
        assertNotNull(books);
        assertEquals("Seven Languages in Seven Weeks", books[0]);
        assertEquals("Testing Extreme Programming", books[1]);
        assertEquals("Ubuntu Kung Fu", books[2]);
    }
}
