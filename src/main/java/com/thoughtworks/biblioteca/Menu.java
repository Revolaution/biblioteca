package com.thoughtworks.biblioteca;


import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    private PrintStream printStream;
    private UserScanner scanner;
    private Biblioteca biblioteca;

    public Menu(PrintStream printStream, UserScanner userScanner, Biblioteca biblioteca) {

        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.scanner = userScanner;
    }

    public void handleOptions() {
        printStream.println("1. List Books");
        printStream.println("2. Quit");

        Map<Integer,Command> options = new HashMap<>();
        options.put(1, new ListBooks(biblioteca));
        options.put(2,new Quit(printStream));

        int input = scanner.nextInt();
        if (input < 3){
            options.get(input).execute();
        }
        else {
            printStream.println("Select a valid option!");
            handleOptions();
        }

//        switch (input) {
//            case 1:
//                biblioteca.listBooks() ;
//                //options.add(ListBooks(Biblioteca biblioteca)
//                break ;
//            case 2:
//                printStream.println("Thank you for using the Biblioteca..?");
//                break;
//            default:
//                printStream.println("Select a valid option!");
//                break;
//        }
    }


}
