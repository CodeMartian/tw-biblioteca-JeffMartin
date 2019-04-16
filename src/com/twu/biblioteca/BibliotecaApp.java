package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu menu = new Menu(System.out, new Scanner(System.in));
        try {
            menu.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
