package com.javaccinations.utilties;

import java.util.Scanner;

public class UserInput {
    static Scanner scanner = new Scanner(System.in);

    public static String getUserInputString(){
        return scanner.nextLine();
    }
    public static Double getUserInputDouble(){
        return scanner.nextDouble();

    }public static int getUserInputInteger(){
        return scanner.nextInt();
    }
}