package com.thoughtworks.biblioteca;


public class ListBooks implements Command {

    private Biblioteca biblioteca;

    public ListBooks(Biblioteca biblioteca) {

        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {
        biblioteca.listBooks();
    }
}
