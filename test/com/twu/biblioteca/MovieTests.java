package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MovieTests {
    private Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("The Lion King");
    }

    @Test
    public void getTitleShouldReturnTitle() {
        //Act
        String result = movie.getTitle();
        //Assert
        assertThat(result, is("The Lion King"));
    }
}
