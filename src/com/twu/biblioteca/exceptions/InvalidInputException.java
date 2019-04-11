package com.twu.biblioteca.exceptions;

import java.io.IOException;

public class InvalidInputException extends IOException {
    private String message;

    public InvalidInputException() {
        this.message = "You have entered an invalid input. Please try again.";
    }

    public String getMessage() {
        return this.message;
    }
}
