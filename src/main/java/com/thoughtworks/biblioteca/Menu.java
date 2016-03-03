package com.thoughtworks.biblioteca;


import java.io.PrintStream;

public class Menu {

    private PrintStream printStream;
    private UserScanner scanner;
    private Biblioteca biblioteca;

    public Menu(PrintStream printStream, UserScanner userScanner, Biblioteca biblioteca) {

        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.scanner = userScanner;
    }

    public void handleOptions() {
        printStream.println("1. List Books");
        printStream.println("2. Quit");
        int input = scanner.nextInt() ;

        switch (input) {
            case 1:
                biblioteca.listBooks() ;
                break ;
            case 2:
                printStream.println("Thank you for using the Biblioteca..?");
                break;
            default:
                printStream.println("Select a valid option!");
                break;
        }
    }


    public void display() {
    }

    public void getUserInput() {
    }
}