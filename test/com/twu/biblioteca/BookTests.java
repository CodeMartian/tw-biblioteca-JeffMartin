package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BookTests {

    @Test
    public void getTitleShouldReturnTitle() {
        //Arrange
        Book book = new Book("Test");
        //Act
        String result = book.getTitle();
        //Assert
        assertEquals("Test", result);
    }
}
