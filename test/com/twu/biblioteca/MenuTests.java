package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidInputException;
import org.junit.Before;
import org.junit.Test;


public class MenuTests {
    private Menu menu;

    @Before
    public void setUp() {
        this.menu = new Menu();
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
