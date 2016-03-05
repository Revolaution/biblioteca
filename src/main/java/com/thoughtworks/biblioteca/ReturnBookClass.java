package com.thoughtworks.biblioteca;

import java.io.IOException;

public class ReturnBookClass implements Command {
    private Biblioteca biblioteca;

    public ReturnBookClass(Biblioteca biblioteca) {

        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {
        try {
            biblioteca.returnBook();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
