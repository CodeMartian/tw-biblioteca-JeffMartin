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
}
