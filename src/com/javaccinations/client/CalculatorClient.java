package com.javaccinations.client;

import com.javaccinations.utilties.Prompter;

public class CalculatorClient {
    public static void main(String[] args) {
        start();
    }

    public static void start(){
        Prompter.namePrompt();
        Prompter.typePrompt();
    }
}