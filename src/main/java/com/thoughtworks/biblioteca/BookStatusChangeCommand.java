package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class BookStatusChangeCommand implements Command{
    private final BookCommand bookCommand;
    private final String prompt;
    private BufferedReader bufferedReader;

    private final String errorMessage;
    private Biblioteca biblioteca;
    private PrintStream printStream;

    public BookStatusChangeCommand(Biblioteca biblioteca, BookCommand bookCommand, String prompt, BufferedReader bufferedReader, String errorMessage, PrintStream printStream) {
        this.biblioteca = biblioteca;
        this.bookCommand = bookCommand;
        this.prompt = prompt;
        this.bufferedReader = bufferedReader;
        this.errorMessage = errorMessage;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        printStream.println(prompt);
        String isbn = readLine();
        biblioteca.actOnBook(isbn, bookCommand, errorMessage);
    }

    private String readLine()  {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
