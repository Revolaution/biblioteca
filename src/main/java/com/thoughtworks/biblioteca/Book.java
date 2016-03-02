package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class Book {

    private String title;
    private String author;
    private int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public void printInformation(PrintStream printStream) {
        //return title + " | " + author + " | " + yearPublished;
        printStream.printf("%-30.30s  %-30.30s %-30.30s%n", title, author, yearPublished) ;

    }
}
