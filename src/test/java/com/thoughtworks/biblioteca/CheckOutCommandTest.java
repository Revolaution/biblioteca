package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckOutCommandTest {

    @Test
    public void shouldCheckInBookWhenExecuting(){
        Book book = mock(Book.class);
        CheckOutCommand checkOutCommand = new CheckOutCommand();
        checkOutCommand.execute(book);
        verify(book).checkOut();
    }
}