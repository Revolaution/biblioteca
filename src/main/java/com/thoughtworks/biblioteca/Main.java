package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> listOfBooks = new ArrayList<>();
        PrintStream printStream = System.out;
        listOfBooks.add(new Book(printStream,"50 Shades of Grey","EL James",2011));
        listOfBooks.add(new Book(printStream,"Twilight","Stephanie Meyers",2005));
        UserScanner scanner = new UserScanner() ;
        Biblioteca biblioteca = new Biblioteca(printStream,  listOfBooks, scanner);
        biblioteca.greetCustomer();
        QuitCommand quitCommand = new QuitCommand(printStream);
        Menu menu = new Menu(printStream,scanner,biblioteca, quitCommand);
        menu.handleOptions();
    }
}
