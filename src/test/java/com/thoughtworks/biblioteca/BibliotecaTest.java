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
    public void listBooks_shouldListBooks() {
        listOfBooks.add(book);
        when(book.printInformation(print)).thenReturn("Harry Potter by JK Rowling");
        biblioteca.listBooks();
        verify(print).println("Harry Potter by JK Rowling");
    }

    @Test
    public void shouldListTwoBooksWhenThereAreTwoBooksInCollection(){
        Book book2 = mock(Book.class) ;
        listOfBooks.add(book);
        listOfBooks.add(book2);
        when(book2.printInformation()).thenReturn("Adam's Favorite Book");
        biblioteca.listBooks();
        verify(print).println("Adam's Favorite Book");
    }

    //@Test
    //public void
}
