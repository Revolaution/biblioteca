package com.thoughtworks.biblioteca;

public class ReturnBookCommand implements BookCommand {
    @Override
    public void execute(Book book) {
        book.checkIn();
    }
}
