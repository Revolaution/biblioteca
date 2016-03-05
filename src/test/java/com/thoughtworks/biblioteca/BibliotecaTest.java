package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private PrintStream printStream;
    private Book book;
    private BufferedReader bufferedReader;
    private Map<String, Book> bookMap;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        bookMap = new HashMap<String,Book>();
        book = mock(Book.class);
        bookMap.put("001",book);
        bufferedReader = mock(BufferedReader.class);
        biblioteca = new Biblioteca(printStream, bookMap,bufferedReader );
    }

    @Test
    public void greetCustomer_shouldGreetCustomer(){
        biblioteca.greetCustomer();
        verify(printStream).println("Welcome");
    }

    @Test
    public void shouldListTwoBooks(){
        Book book2 = mock(Book.class) ;
        bookMap.put("2",book2);
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
    public void shouldCheckOutABookWhenGivenTheISBN() throws IOException {
        when(bufferedReader.readLine()).thenReturn("001");
        biblioteca.checkOutBook();
        verify(book).checkOut();
    }

    @Test
    public void shouldOnlyPrintBooksWhenTheyAreNotCheckedOut(){
        biblioteca.listBooks();
        verify(book).ableToBeCheckedOut();
    }

    @Test
    public void shouldTellUserOfUnsuccessfulCheckOutWhenBookNotAvailable() throws IOException {
        when(bufferedReader.readLine()).thenReturn("5");
        biblioteca.checkOutBook();
        verify(printStream).println("That book is not available");
    }

    @Test
    public void shouldAllowUserToReturnBookWhenGivenISBN() throws IOException {
        when(bufferedReader.readLine()).thenReturn("001");
        biblioteca.returnBook();
        verify(book).checkIn();
    }

    @Test
    public void shouldTellUserIfCannotReturnBook() throws IOException {
        when(bufferedReader.readLine()).thenReturn("100");
        biblioteca.returnBook();
        verify(printStream).println(contains("not a valid book"));
    }
}
