package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private PrintStream printStream;
    private Book book;
    private List<Book> listOfBooks;
    private UserScanner scanner;
    private Menu menu;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        listOfBooks = new ArrayList<Book>();
        book = mock(Book.class);
        listOfBooks.add(book) ;
        scanner = mock(UserScanner.class) ;
        menu = mock(Menu.class);
        biblioteca = new Biblioteca(printStream, listOfBooks, scanner);
    }

    @Test
    public void greetCustomer_shouldGreetCustomer(){
        biblioteca.greetCustomer();

        verify(printStream).println("Welcome");
    }



    @Test
    public void shouldListTwoBooks(){
        Book book2 = mock(Book.class) ;


        listOfBooks.add(book);
        listOfBooks.add(book2);

        biblioteca.listBooks();



        verify(book2).print();
    }




}
