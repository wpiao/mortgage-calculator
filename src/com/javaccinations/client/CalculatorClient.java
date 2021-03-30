package com.javaccinations.client;

import com.javaccinations.Calculator.Calculator;
import com.javaccinations.utilties.Prompter;
import com.javaccinations.utilties.UserInput;

public class CalculatorClient {
    static Calculator calc;

    public static void main(String[] args) {
        System.out.println("Please enter your name to start the application:\n> ");
        System.out.println("Hello " + UserInput.getUserInput());
        start();
    }

    public static void start(){
        System.out.println("Please select a Calculator: ");
        Prompter.calcPrompt();
        String type = UserInput.getUserInput();

        switch (type){
            case "1" : Prompter.mortgageCalculatorPrompts();
                        break;
            case "2" : calc=Prompter.refinanceCalculatorPrompts();
                        //calc.
                        break;
            case "3" : Prompter.amortizationPrompts();
                        break;
            case "4" : System.exit(0);
            default:
                System.out.println("Invalid Entry!! Please select one of the entries below :");
                start();

        }

    }


}