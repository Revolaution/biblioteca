package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

public class Biblioteca {

    private PrintStream printStream;
    private Map<String, Book> bookMap;
    private BufferedReader bufferedReader;


    public Biblioteca(PrintStream printStream, Map<String, Book> bookMap, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bookMap = bookMap;
        this.bufferedReader = bufferedReader;
    }

    public void greetCustomer() {
        printStream.println("Welcome");
    }

    public void listBooks() {
        for (Map.Entry<String, Book> entry : bookMap.entrySet()){
            if (entry.getValue().ableToBeCheckedOut()){
                entry.getValue().print();
            }
        }
    }

    public void checkOutBook() throws IOException {
        printStream.println("Which book's isbn would you like to check out?");
        String input = bufferedReader.readLine();
        if (bookMap.containsKey(input)){
            bookMap.get(input).checkOut();
        }
        else {
            printStream.println("That book is not available");
        }
    }

    public void returnBook() throws IOException {
        printStream.println("Enter the ISBN of the book you want to return");
        String input = bufferedReader.readLine();
        if (bookMap.containsKey(input)){
            bookMap.get(input).checkIn();
        }
        else {
            printStream.println("That is not a valid book to return.");
        }
    }
}
