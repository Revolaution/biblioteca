package com.thoughtworks.biblioteca;


public class ListBooksCommand implements Command {

    private Biblioteca biblioteca;

    public ListBooksCommand(Biblioteca biblioteca) {

        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {
        biblioteca.listBooks();
    }
}
