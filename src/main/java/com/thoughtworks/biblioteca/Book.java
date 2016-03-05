package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class Book {

    private PrintStream printStream;
    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    public Boolean checkedOut;

    public Book(PrintStream printStream, String title, String author, int yearPublished, String isbn) {
        this.printStream = printStream;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.checkedOut = false;
    }


    public void print() {
        printStream.println("ISBN: " + this.isbn + " | " + this.title + " | " + this.author + " | " + this.yearPublished);
    }

    public void checkOut() {
        checkedOut = true;
        printStream.println("Thank you! Enjoy the book");
    }

    public boolean ableToBeCheckedOut() {
        return checkedOut == false;
    }

    public void checkIn() {
        checkedOut = false;
        printStream.println("Thank you for returning the book.");
    }
}
