package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieTests {

    @Test
    public void getTitleShouldReturnTitle() {
        Movie movie = new Movie("Fantastic Beasts and Where To Find Them");

        String result = movie.getTitle();

        assertThat(result, is("Fantastic Beasts and Where To Find Them"));
    }

    @Test
    public void isCheckedOutShouldReturnTrue() {
        Movie movie = new Movie("Fantastic Beasts and Where To Find Them");

        boolean isCheckedOut = movie.isCheckedOut();

        assertThat(isCheckedOut, is(false));
    }

    @Test
    public void checkOutMovieShouldReturnMovieCheckedOut() {
        Movie movie = new Movie("Test");

        boolean result = movie.setCheckedOut();

        assertThat(result, is(true));
    }

    @Test
    public void checkOutAlreadyCheckedOutMovieShouldReturnFalse() {
        Movie movie = new Movie("Test");

        movie.setCheckedOut();
        boolean result = movie.setCheckedOut();

        assertThat(result, is(false));
    }
}
