package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GivenWelcomeMessage {

    @Test
    public void testWelcomeMessageShouldReturnMessage() {
        //Arrange
        String message = "Hello World!";
        BibliotecaLibrary bibliotecaLibrary = new BibliotecaLibrary();
        //Act
        bibliotecaLibrary.setWelcomeMessage(message);
        //Assert
        assertEquals("Hello World!", bibliotecaLibrary.getWelcomeMessage());
    }
}
