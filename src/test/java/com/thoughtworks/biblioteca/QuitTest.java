package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class QuitTest {


    private PrintStream printStream;


    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldPrintQuitMessageWhenExecuting(){
        Quit quit = new Quit(printStream);

        quit.execute();

        verify(printStream).println(contains("Thank you for using the Biblioteca..?"));
    }


}