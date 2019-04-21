package com.twu.biblioteca;

public class Movie {
    private String title;
    //private boolean isCheckedOut;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

//    public boolean isCheckedOut() {
//        return this.isCheckedOut;
//    }
//
//    public boolean setCheckedOut() {
//        if (this.isCheckedOut) {
//            return false;
//        }
//        return this.isCheckedOut = true;
//    }
}
