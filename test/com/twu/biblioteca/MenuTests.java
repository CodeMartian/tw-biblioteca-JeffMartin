package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidInputException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuTests {
    private Menu menu;

    @Before
    public void setUp() {
        this.menu = new Menu();
    }

    @Test
    public void testValidateMenuInputShouldReturn() throws InvalidInputException {
        //Arrange
        int input = 1;
        //Act
        menu.validateInput(input);
    }

    @Test
    public void testValidateMenuInputShouldThrowException() {
        //Arrange
        int input = 9999999;
        //Act
        try {
            menu.validateInput(input);
        } catch (InvalidInputException ex) {
            assertEquals("You have entered an invalid input. Please try again.", ex.getMessage());
        }
    }
}
