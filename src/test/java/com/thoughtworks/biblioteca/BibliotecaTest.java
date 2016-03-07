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
    private BookCommand bookCommand;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        bookMap = new HashMap<String,Book>();
        book = mock(Book.class);
        bufferedReader = mock(BufferedReader.class);
        biblioteca = new Biblioteca(printStream, bookMap,bufferedReader );
        bookCommand = mock(BookCommand.class);
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
    public void shouldOnlyPrintBooksWhenTheyAreNotCheckedOut(){
        bookMap.put("001", book);
        biblioteca.listBooks();
        verify(book).ableToBeCheckedOut();
    }

    @Test
    public void shouldPrintErrorMessageWhenBookNotAvailable() throws IOException {
        biblioteca.actOnBook("Some Book", bookCommand, "That book is not available" );
        verify(printStream).println("That book is not available");
    }

    @Test
    public void shouldExecuteBookCommandWhenBookIsInLibrary() throws IOException {
        bookMap.put("001", book);
        biblioteca.actOnBook("001", bookCommand, "That is not a valid book to return.");
        verify(bookCommand).execute(book);
    }

    @Test
    public void shouldNotExecuteBookCommandWhenBookIsNotInLibrary() throws IOException {
        biblioteca.actOnBook("001", bookCommand, "That is not a valid book to return.");
        verify(bookCommand, never()).execute(any(Book.class));
    }

    @Test
    public void shouldNotPrintErrorMessageWhenBookIsInLibrary() throws IOException {
        bookMap.put("001", book);
        biblioteca.actOnBook("001", bookCommand, "That is not a valid book to return.");
        verify(printStream, never()).println("That book is not available");
    }
}
