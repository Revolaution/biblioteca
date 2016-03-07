package com.thoughtworks.biblioteca;

public class CheckOutCommand implements BookCommand {
    @Override
    public void execute(Book book) {
        book.checkOut();
    }
}
