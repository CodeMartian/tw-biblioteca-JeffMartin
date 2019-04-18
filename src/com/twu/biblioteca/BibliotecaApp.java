package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu menu = new Menu(System.out, new BufferedReader(new InputStreamReader(System.in)));
        try {
            menu.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
