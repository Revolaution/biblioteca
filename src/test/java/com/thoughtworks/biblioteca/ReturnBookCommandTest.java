package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReturnBookCommandTest {
    @Test
    public void shouldCheckInBookWhenExecuting(){
        Book book = mock(Book.class);
        ReturnBookCommand returnBookCommand = new ReturnBookCommand();
        returnBookCommand.execute(book);
        verify(book).checkIn();
    }
}