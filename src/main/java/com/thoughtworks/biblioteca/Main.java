package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Book> listOfBooks = new ArrayList<>();
        PrintStream printStream = System.out;
        UserScanner scanner = new UserScanner() ;
        Biblioteca biblioteca = new Biblioteca(printStream,  listOfBooks, scanner);
        biblioteca.run();
    }
}
