package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private PrintStream printStream;
    private Book book;
    private List<Book> listOfBooks;
    private UserScanner scanner;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        listOfBooks = new ArrayList<Book>();
        book = mock(Book.class);
        listOfBooks.add(book) ;
        scanner = mock(UserScanner.class) ;
        biblioteca = new Biblioteca(printStream, listOfBooks, scanner);
    }

    @Test
    public void greetCustomer_shouldGreetCustomer(){
        biblioteca.greetCustomer();

        verify(printStream).println("Welcome");
    }



    @Test
    public void shouldListTwoshBooks(){
        Book book2 = mock(Book.class) ;


        listOfBooks.add(book);
        listOfBooks.add(book2);

        biblioteca.listBooks();



        verify(book2).print();
    }


    @Test
    public void shouldDisplayMenuOptionAfterStartup() {
        biblioteca.run() ;
        verify(printStream).println("1. List Books") ;
    }


    @Test
    public void shouldListBooksWhenUserEnters1AfterMenuDisplayed() {
        when(scanner.nextInt()).thenReturn(1) ;
        biblioteca.handleUserInput() ;

        verify(book).print() ;
    }

    @Test
    public void shouldGiveErrorMessageWhenUserEntersInvalidInput(){
        when(scanner.nextInt()).thenReturn(10000);
        biblioteca.handleUserInput();

        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldExitBibliotecaWhenUserEntersQuit(){
        when(scanner.nextInt()).thenReturn(2);
        biblioteca.handleUserInput();

        verify(printStream).println("Thank you for using the Biblioteca..?");
    }

}
