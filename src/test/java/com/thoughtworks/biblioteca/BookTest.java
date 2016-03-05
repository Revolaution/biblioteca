package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {


    private PrintStream printStream;
    private Book book;


    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class) ;
        book = new Book(printStream, "Harry Potter","JK Rowling",1991, "001");
    }


    @Test
    public void shouldPrintTitle() {
        book.print();
        verify(printStream).println(contains("Harry Potter")) ;
    }

    @Test
    public void shouldPrintAuthor() {
        book.print();
        verify(printStream).println(contains("JK Rowling")) ;
    }
    @Test
    public void shouldPrintYear() {
        book.print();
        verify(printStream).println(contains("1991")) ;
    }

    @Test
    public void shouldPrintISBN(){
        book.print();
        verify(printStream).println(contains("001"));
    }
    @Test
    public void shouldChangeCheckedOutStatus(){
        book.checkOut();
        assertThat(book.checkedOut, is(true));
    }

    @Test
    public void shouldTellUserBookHasBeenCheckedOutWhenCheckedOut(){
        book.checkOut();
        verify(printStream).println(contains("Enjoy the book"));
    }

    @Test
    public void shouldReturnBooleanIfBookIsAbleToBeCheckedOut(){
        book.ableToBeCheckedOut();
        assertThat(book.ableToBeCheckedOut(), is(true));
    }

    @Test
    public void shouldTellUserIfBookHasBeenCheckedIn(){
        book.checkIn();
        verify(printStream).println(contains("returning the book"));
    }

}