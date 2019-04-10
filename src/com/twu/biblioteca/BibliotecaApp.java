package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaLibrary bibliotecaLibrary = new BibliotecaLibrary();
        bibliotecaLibrary.setWelcomeMessage("Welcome to Biblioteca! Your one-stop-shop for books in Bangalore!");
        System.out.println(bibliotecaLibrary.getWelcomeMessage());
        for (String book : bibliotecaLibrary.listAllBooks()) {
            System.out.print(book + "\n");
        }
    }
}
