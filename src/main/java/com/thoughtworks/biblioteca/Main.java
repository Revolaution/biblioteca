package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Book> bookMap = new HashMap<String, Book>();
        PrintStream printStream = System.out;

        bookMap.put("001", new Book(printStream,"50 Shades of Grey","EL James",2011, "001"));
        bookMap.put("002", new Book(printStream,"Twilight","Stephanie Meyers",2005, "002"));

        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        Biblioteca biblioteca = new Biblioteca(printStream,bookMap,bufferedReader );

        QuitCommand quitCommand = new QuitCommand(printStream);
        Menu menu = new Menu(printStream, bufferedReader, biblioteca, quitCommand);

        biblioteca.greetCustomer();
        menu.handleOptions();
    }
}
