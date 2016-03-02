package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void printTitleAndAuthor_shouldFormatBook1(){
        Book book = new Book("Lean Out", "Elissa", 2015);
        String result = book.printInformation();
        assertThat(result, is("Lean Out by Elissa. 2015"));
    }

    @Test
    public void printTitleAndAuthor_shouldFormatBook2(){
        Book book = new Book("Harry Potter", "JK Rowling", 1997);
        String result = book.printInformation();
        assertThat(result, is("Harry Potter by JK Rowling. 1997"));
    }

    @Test
    public void shouldPrintAuthorAndYearFormatted() {

    }
}