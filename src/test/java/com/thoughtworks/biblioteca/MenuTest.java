package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
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
    private QuitCommand quitCommand;
    private BufferedReader bufferedReader;

    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        scanner = mock(UserScanner.class) ;
        biblioteca = mock(Biblioteca.class);
        quitCommand = mock(QuitCommand.class);
        bufferedReader = mock(BufferedReader.class);
        menu = new Menu(printStream, bufferedReader, biblioteca, quitCommand);
    }

    @Test
    public void shouldDisplayMenuAfterStart() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1") ;
        menu.showMenu();
        verify(printStream).println(contains("1. List Books"));
        verify(printStream).println(contains("Q. Quit"));
    }

    @Test
    public void shouldListBooksWhenUserEnters1AfterMenuDisplayed() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1") ;
        when(quitCommand.getShouldRun()).thenReturn(true).thenReturn(false);
        menu.handleOptions();

        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldGiveErrorMessageWhenUserEntersInvalidInput() throws IOException {
        when(bufferedReader.readLine()).thenReturn("10000").thenReturn("1");
        when(quitCommand.getShouldRun()).thenReturn(true).thenReturn(false);
        menu.handleOptions();

        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldExitBibliotecaWhenUserEntersQuit() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Q");
        when(quitCommand.getShouldRun()).thenReturn(true).thenReturn(false);
        menu.handleOptions();

        verify(quitCommand).execute();
    }


}