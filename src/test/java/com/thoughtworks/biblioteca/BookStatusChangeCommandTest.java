package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.Buffer;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookStatusChangeCommandTest {

    private Biblioteca biblioteca;
    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private BookCommand bookCommand;
    private BookStatusChangeCommand bookStatusChangeCommand;

    @Before
    public void setUp() throws Exception {
        biblioteca = mock(Biblioteca.class);
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        bookCommand = mock(BookCommand.class);
        bookStatusChangeCommand = new BookStatusChangeCommand(biblioteca, bookCommand, "Which book's ISBN would you like to check out?", bufferedReader, "That book is not available", printStream);
    }

    @Test
    @Ignore
    public void shouldCheckoutFromBibliotecaWhenExecuting() throws IOException {
        Biblioteca biblioteca = mock(Biblioteca.class);
//        BookStatusChangeCommand bookStatusChangeCommand = new BookStatusChangeCommand(biblioteca, new CheckOutCommand(), "Which book's ISBN would you like to check out?", bufferedReader, "That book is not available", printStream);
//
//        bookStatusChangeCommand.execute();
//
//        verify(biblioteca).actOnBook(new CheckOutCommand(), "Which book's ISBN would you like to check out?", "That book is not available");
    }

    @Test
    public void shouldPrintPromptWhenToldToExecute() {
        bookStatusChangeCommand.execute();
        verify(printStream).println("Which book's ISBN would you like to check out?");
    }

//    @Test
//    public void shouldActOneBookWhenToldToExecute(){
//
//        bookStatusChangeCommand.execute();
//        verify(biblioteca).actOnBook(bookCommand, "That book is not available");
//    }




}