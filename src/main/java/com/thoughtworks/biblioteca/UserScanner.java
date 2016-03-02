package com.thoughtworks.biblioteca;

import java.util.Scanner;

public class UserScanner {

    private Scanner scanner;

    public UserScanner(){
        this.scanner = new Scanner(System.in);
    }

    public int nextInt(){
        return scanner.nextInt();
    }

}
