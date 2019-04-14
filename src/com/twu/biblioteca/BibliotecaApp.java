package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu menu = new Menu();
        try {
            menu.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
