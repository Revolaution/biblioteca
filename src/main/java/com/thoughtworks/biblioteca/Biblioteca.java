package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

public class Biblioteca {

    private PrintStream printStream;
    private Map<String, Book> bookMap;
    private BufferedReader bufferedReader;


    public Biblioteca(PrintStream printStream, Map<String, Book> bookMap, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bookMap = bookMap;
        this.bufferedReader = bufferedReader;
    }

    public void greetCustomer() {
        printStream.println("Welcome");
    }

    public void listBooks() {
        for (Map.Entry<String, Book> entry : bookMap.entrySet()){
            if (entry.getValue().ableToBeCheckedOut()){
                entry.getValue().print();
            }
        }
    }

    public void actOnBook(String input, BookCommand bookCommand, String errorMessage) {
        if (bookMap.containsKey(input)){
            Book book = bookMap.get(input);
            bookCommand.execute(book);
        }
        else {
            printStream.println(errorMessage);
        }
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
