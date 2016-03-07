package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ListBooksCommandTest {

    private Biblioteca biblioteca;
    private ListBooksCommand listCommand;

    @Before
    public void setup(){
        biblioteca = mock(Biblioteca.class);

        listCommand = new ListBooksCommand(biblioteca);
    }

    @Test
    public void shouldListBooksOnExecuteCall(){
        listCommand.execute();

        verify(biblioteca).listBooks();
    }


}