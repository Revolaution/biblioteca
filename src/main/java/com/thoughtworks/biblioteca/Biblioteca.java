package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class Biblioteca {

    private PrintStream print;

    public Biblioteca(PrintStream print) {
        this.print = print;
    }


    public void greetCustomer() {
        print.println("Welcome");
    }
}
