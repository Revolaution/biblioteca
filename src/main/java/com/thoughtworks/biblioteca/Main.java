package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> listOfBooks = new ArrayList<>();
        PrintStream printStream = System.out;
        listOfBooks.add(new Book(printStream, "POODR", "Sandi Metz", 2015));
        listOfBooks.add(new Book(printStream, "Bible", "God", 6000)) ;
        Biblioteca biblioteca = new Biblioteca(printStream,  listOfBooks);
        biblioteca.greetCustomer();
        biblioteca.listBooks();
    }
}
