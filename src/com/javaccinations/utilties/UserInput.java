package com.javaccinations.utilties;

import java.util.Scanner;

public class UserInput {
    static Scanner scanner = new Scanner(System.in);

    public static String getUserInput(){
        return scanner.nextLine();
    }
}