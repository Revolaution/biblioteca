package com.thoughtworks.biblioteca;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    private QuitCommand quitCommand;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Biblioteca biblioteca;
    private Map<String,Command> options;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, Biblioteca biblioteca, QuitCommand quitCommand) {

        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.biblioteca = biblioteca;
        this.quitCommand = quitCommand;
        this.options = new HashMap<String, Command>();
        addOptionCommands();
    }

    private void addOptionCommands(){
        options.put("1", new ListBooksCommand(biblioteca));
        options.put("2", new BookStatusChangeCommand(biblioteca, new CheckOutCommand(), "Which book's ISBN would you like to check out?", bufferedReader, "That book is not available", printStream));
        options.put("3", new BookStatusChangeCommand(biblioteca, new ReturnBookCommand(), "Which book's ISBN would you like to check in?", bufferedReader, "That book is not checkout", printStream));
        options.put("Q", quitCommand);
    }

    public void handleOptions() throws IOException {

        while (quitCommand.getShouldRun()){
            showMenu();
            String input = bufferedReader.readLine();
            if (options.containsKey(input)){
                options.get(input).execute();
            }
            else {
                printStream.println("Select a valid option!");
            }
        }

    }
    
    public void showMenu() {
        printStream.println("1. List Books");
        printStream.println("2. Check Out A Book");
        printStream.println("3. Return A Book");
        printStream.println("Q. Quit");
    }
}
