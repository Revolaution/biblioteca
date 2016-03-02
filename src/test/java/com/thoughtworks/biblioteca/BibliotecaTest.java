package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private PrintStream print;
    private Book book;
    private List<Book> listOfBooks;

    @Before
    public void setUp(){
        print = mock(PrintStream.class);
        listOfBooks = new ArrayList<Book>();
        book = mock(Book.class);
        biblioteca = new Biblioteca(print, listOfBooks);
    }

    @Test
    public void greetCustomer_shouldGreetCustomer(){
        biblioteca.greetCustomer();

        verify(print).println("Welcome");
    }



    @Test
    public void shouldListTwoshBooks(){
        Book book2 = mock(Book.class) ;


        listOfBooks.add(book);
        listOfBooks.add(book2);

        biblioteca.listBooks();



        verify(book2).print();
    }

}
