package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        Biblioteca bib = new Biblioteca(System.out);
        bib.greetCustomer();
    }
}
