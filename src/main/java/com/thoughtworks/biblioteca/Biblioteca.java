package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private UserScanner scanner;
    private PrintStream printStream;
    private List<Book> listOfBooks;


    public Biblioteca(PrintStream printStream, List<Book> listOfBooks, UserScanner scanner) {
        this.printStream = printStream;
        this.listOfBooks = listOfBooks;
        this.scanner = scanner ;
    }

    public void run() {
        greetCustomer() ;
        showmenu() ;
    }

    public void greetCustomer() {
        printStream.println("Welcome");
    }

    public void listBooks() {
        for (Book book: listOfBooks){
            book.print();
        }
    }



    private void showmenu() {
        printStream.println("1. List Books") ;
    }

    public void getUserInput() {
        int input = scanner.nextInt() ;
        switch (input) {
            case 1:
                listBooks() ;
                break ;
            default:
                printStream.println("Select a valid option!");
                break;
        }
    }
}
