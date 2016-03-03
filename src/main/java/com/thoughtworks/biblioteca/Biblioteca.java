package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Biblioteca {

    private UserScanner scanner;
    private PrintStream printStream;
    private List<Book> listOfBooks;


    public Biblioteca(PrintStream printStream, List<Book> listOfBooks, UserScanner scanner) {
        this.printStream = printStream;
        this.listOfBooks = listOfBooks;
        this.scanner = scanner ;
    }

    public void greetCustomer() {

        printStream.println("Welcome");
    }

    public void listBooks() {
        for (Book book: listOfBooks){
            book.print();
        }
    }



}
