package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaTest {
    @Test
    public void shouldGreetCustomer(){
        PrintStream print = mock(PrintStream.class);
        Biblioteca bib = new Biblioteca(print);

        bib.greetCustomer();

        verify(print).println("Welcome");
    }

}
