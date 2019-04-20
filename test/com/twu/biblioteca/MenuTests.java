package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidInputException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class MenuTests {
    private Menu menu;
    private PrintStream mockPrintStream;
    private BufferedReader mockReader;

    @Before
    public void setUp() {
        this.mockPrintStream = mock(PrintStream.class);
        this.mockReader = mock(BufferedReader.class);
        this.menu = new Menu(mockPrintStream, mockReader);
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

//    @Test
//    public void printMovieListShouldPrintListOfMovies() {
//        //Arrange
//        Movie mockMovie = mock(Movie.class);
//        when(mockMovie).
//        ArrayList<Movie> movies = new ArrayList<Movie>();
//        movies.add()
//
//        menu.printMovieList(movies);
//        verify(mockPrintStream).printf("%-10s", "Movies");
//        verify(mockPrintStream).printf("%-40s", "Fantastic Beasts and Where To Find Them");
//        verify(mockPrintStream).printf("%-40s", "Mary Poppins");
//        verify(mockPrintStream).printf("%-40s", "Mortal Engines");
//
//
//    }
}
