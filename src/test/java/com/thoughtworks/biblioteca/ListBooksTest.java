package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ListBooksTest {

    private Biblioteca biblioteca;
    private ListBooks listCommand;

    @Before
    public void setup(){
        biblioteca = mock(Biblioteca.class);

        listCommand = new ListBooks(biblioteca);
    }

    @Test
    public void shouldListBooksOnExecuteCall(){
        listCommand.execute();

        verify(biblioteca).listBooks();
    }


}