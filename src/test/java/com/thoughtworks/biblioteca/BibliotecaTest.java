package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private PrintStream printStream;
    private Book book;
    private List<Book> listOfBooks;
    private Menu menu;
    private BufferedReader bufferedReader;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        listOfBooks = new ArrayList<Book>();
        book = mock(Book.class);
        listOfBooks.add(book) ;
        menu = mock(Menu.class);
        bufferedReader = mock(BufferedReader.class);
        biblioteca = new Biblioteca(printStream, listOfBooks,bufferedReader );
        listOfBooks.add(book);
    }

    @Test
    public void greetCustomer_shouldGreetCustomer(){
        biblioteca.greetCustomer();
        verify(printStream).println("Welcome");
    }

    @Test
    public void shouldListTwoBooks(){
        Book book2 = mock(Book.class) ;
        listOfBooks.add(book2);
        when(book2.ableToBeCheckedOut()).thenReturn(true);
        biblioteca.listBooks();
        verify(book2).print();
    }

    @Test
    public void shouldAskCustomerForBookToCheckOut() throws IOException {
        biblioteca.checkOutBook();
        verify(printStream).println(contains("check out"));
    }

    @Test
    public void shouldCheckOutABookWhenGivenTheTitle() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Harry Potter");
        biblioteca.checkOutBook();
        verify(book, times(2)).checkOut("Harry Potter");
    }

    @Test
    public void shouldOnlyPrintBooksWhenTheyAreNotCheckedOut(){
        biblioteca.listBooks();
        verify(book, times(2)).ableToBeCheckedOut();
    }

}
