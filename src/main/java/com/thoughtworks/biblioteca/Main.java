package com.thoughtworks.biblioteca;

import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class Main {
    public static void main(String[] args) {
        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("POODR", "Sandi Metz", 2015));
        listOfBooks.add(new Book("Bible", "God", 6000)) ;
        Biblioteca biblioteca = new Biblioteca(System.out,  listOfBooks);
        biblioteca.greetCustomer();
        biblioteca.listBooks();
    }
}
