package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class Quit implements Command {

    private PrintStream printStream;

    public Quit(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        printStream.println("Thank you for using the Biblioteca..?");
    }
}
