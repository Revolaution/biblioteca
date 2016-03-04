package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Book> listOfBooks = new ArrayList<Book>();
        PrintStream printStream = System.out;
        listOfBooks.add(new Book(printStream,"50 Shades of Grey","EL James",2011));
        listOfBooks.add(new Book(printStream,"Twilight","Stephanie Meyers",2005));
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        Biblioteca biblioteca = new Biblioteca(printStream,listOfBooks, bufferedReader);
        biblioteca.greetCustomer();
        QuitCommand quitCommand = new QuitCommand(printStream);
        Menu menu = new Menu(printStream, bufferedReader, biblioteca, quitCommand);
        menu.handleOptions();
    }
}
