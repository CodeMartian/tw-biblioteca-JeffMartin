package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidInputException;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;


public class MenuTests {
    private Menu menu;
    private PrintStream mockPrintStream;

    @Before
    public void setUp() {
        this.mockPrintStream = mock(PrintStream.class);
        this.menu = new Menu(mockPrintStream);
    }

    @Test
    public void startShouldReturnWelcomeMessage() {
        menu.displayWelcomeMessage();
        verify(mockPrintStream).println("Welcome to Biblioteca! Your one-stop-shop for books in Bangalore!");
    }

    @Test
    public void validateMenuInputShouldReturn() throws InvalidInputException {
        //Act
        menu.validateInput("1");
    }

    @Test(expected = InvalidInputException.class)
    public void validateMenuInputShouldThrowException() throws InvalidInputException {
        //Act
        menu.validateInput("Jeff");
    }
}
