package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
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
    public void testGetAllBooksShouldReturnListOfBooks() {
        //Act
        ArrayList<Book> results = library.getAllBooks();
        //Assert
        assertThat(results.get(0).getTitle(), is("Seven Languages in Seven Weeks"));
        assertThat(results.get(0).getAuthor(), is("Bruce A. Tate"));
        assertThat(results.get(0).getPublicationDate(), is("2010"));
        assertThat(results.get(1).getTitle(), is("Testing Extreme Programming"));
        assertThat(results.get(1).getAuthor(), is("Lisa Crispin"));
        assertThat(results.get(1).getPublicationDate(), is("2003"));
        assertThat(results.get(2).getTitle(), is("Ubuntu Kung Fu"));
        assertThat(results.get(2).getAuthor(), is("Keir Thomas"));
        assertThat(results.get(2).getPublicationDate(), is("2008"));
    }

    @Test
    public void getAllBooksShouldReturnListOfAvailableBooks() {
        //Act
        ArrayList<Book> results = library.getAllBooks();
        //Assert
        assertThat(results.size(), is(3));
    }

    @Test
    public void getBookShouldReturnBook() {
        //Act
        Book result = library.getBook(0);
        //Assert
        assertThat(result.getTitle(), is("Seven Languages in Seven Weeks"));
        assertThat(result.getAuthor(), is("Bruce A. Tate"));
        assertThat(result.getPublicationDate(), is("2010"));

    }
}
