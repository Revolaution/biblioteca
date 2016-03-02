package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class Book {

    private PrintStream printStream;
    private String title;
    private String author;
    private int yearPublished;

    public Book(PrintStream printStream, String title, String author, int yearPublished) {
        this.printStream = printStream;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }


    public void print() {
        printStream.println(this.title + " | " + this.author + " | " + this.yearPublished);
    }
}
