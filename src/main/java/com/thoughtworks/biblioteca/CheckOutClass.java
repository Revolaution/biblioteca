package com.thoughtworks.biblioteca;

import java.io.IOException;

public class CheckOutClass implements Command{
    private Biblioteca biblioteca;

    public CheckOutClass(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {
        try {
            biblioteca.checkOutBook();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
