package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuTest {

    private PrintStream printStream;
    private UserScanner scanner;
    private Menu menu;
    private Biblioteca biblioteca;

    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        scanner = mock(UserScanner.class) ;
        biblioteca = mock(Biblioteca.class);
        menu = new Menu(printStream,scanner, biblioteca);
    }

    @Test
    public void shouldDisplayMenuAfterStart(){
        when(scanner.nextInt()).thenReturn(1) ;
        menu.handleOptions();
        verify(printStream).println(contains("1. List Books"));
        verify(printStream).println(contains("2. Quit"));
    }

    @Test
    public void shouldListBooksWhenUserEnters1AfterMenuDisplayed() {
        when(scanner.nextInt()).thenReturn(1) ;
        menu.handleOptions();

        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldGiveErrorMessageWhenUserEntersInvalidInput(){
        when(scanner.nextInt()).thenReturn(10000).thenReturn(1);
        menu.handleOptions();

        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldExitBibliotecaWhenUserEntersQuit(){
        when(scanner.nextInt()).thenReturn(2);
        menu.handleOptions();

        verify(printStream).println("Thank you for using the Biblioteca..?");
    }

}