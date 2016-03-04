package com.thoughtworks.biblioteca;


import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    private QuitCommand quitCommand;
    private PrintStream printStream;
    private UserScanner scanner;
    private Biblioteca biblioteca;
    private Map<Integer,Command> options;

    public Menu(PrintStream printStream, UserScanner userScanner, Biblioteca biblioteca, QuitCommand quitCommand) {

        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.scanner = userScanner;
        this.quitCommand = quitCommand;
        this.options = new HashMap<>();
        addOptionCommands();
    }

    private void addOptionCommands(){
        options.put(1, new ListBooks(biblioteca));
        options.put(2, quitCommand);
    }

    public void handleOptions() {

        showMenu();
        while (quitCommand.getShouldRun()){
            int input = scanner.nextInt();
            if (input < 3){
                options.get(input).execute();
            }
            else {
                printStream.println("Select a valid option!");
            }
//            handleOptions();
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


    public void showMenu() {
        printStream.println("1. List Books");
        printStream.println("2. Quit");
    }
}
