package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class QuitCommand implements Command {

    private boolean shouldRun;
    private PrintStream printStream;

    public QuitCommand(PrintStream printStream) {
        this.printStream = printStream;
        this.shouldRun = true;
    }

    @Override
    public void execute() {
        printStream.println("Thank you for using the Biblioteca..?");
        shouldRun = false;
    }

    public boolean getShouldRun(){
        return shouldRun;
    }

}
