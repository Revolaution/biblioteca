package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Biblioteca {

    private PrintStream printStream;
    private List<Book> listOfBooks;
    private BufferedReader bufferedReader;


    public Biblioteca(PrintStream printStream, List<Book> listOfBooks, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.listOfBooks = listOfBooks;
        this.bufferedReader = bufferedReader;
    }

    public void greetCustomer() {
        printStream.println("Welcome");
    }

    public void listBooks() {
        for (Book book: listOfBooks){
            if (book.ableToBeCheckedOut()){
                book.print();
            }
        }
    }

    public void checkOutBook() throws IOException {
        printStream.println("Which book title would you like to check out?");
        String input = bufferedReader.readLine();
        for(Book book: listOfBooks){
            book.checkOut(input);
        }
    }
}
