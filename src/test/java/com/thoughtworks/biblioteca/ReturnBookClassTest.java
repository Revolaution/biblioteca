package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReturnBookClassTest {

    @Test
    public void shouldReturnBookOnExecuteCall() throws IOException {
        Biblioteca biblioteca = mock(Biblioteca.class);
        ReturnBookClass returnBookClass = new ReturnBookClass(biblioteca);
        returnBookClass.execute();
        verify(biblioteca).returnBook();
    }


}