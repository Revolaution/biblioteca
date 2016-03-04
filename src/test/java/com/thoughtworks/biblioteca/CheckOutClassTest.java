package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckOutClassTest {
    @Test
    public void shouldCheckoutFromBibliotecaWhenExecuting() throws IOException {
        Biblioteca biblioteca = mock(Biblioteca.class);
        CheckOutClass checkOutClass = new CheckOutClass(biblioteca);
        checkOutClass.execute();
        verify(biblioteca).checkOutBook();
    }


}