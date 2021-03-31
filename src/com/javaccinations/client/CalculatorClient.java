package com.javaccinations.client;

import com.javaccinations.calculator.CalcFactory;
import com.javaccinations.calculator.Calculator;
import com.javaccinations.calculator.Mortgage;
import com.javaccinations.utilties.Prompter;
import com.javaccinations.utilties.UserInput;

public class CalculatorClient {
    static Calculator calc;
    public static void main(String[] args) {
        System.out.println("\n********* Welcome to the Mortgage Calculator ********** \n");
        System.out.print("Please enter your name to start the application: \n> ");
        System.out.println("\nHello " + UserInput.getUserInputString() + "!!\n");
        start();
    }

    public static void start(){
        System.out.println("Please select a Calculator: ");
        Prompter.calcPrompt();
        System.out.print("> ");
        String type = UserInput.getUserInputString();
        System.out.println();
        Mortgage mortgage = new Mortgage();

        switch (type){
            case "1" :
                        calc= CalcFactory.createCalculator("Purchase");
                        Prompter.mortgageCalculatorPrompts(mortgage);
                        calc.display(mortgage);
                        break;
            case "2" :
                       calc = CalcFactory.createCalculator("Refinance");
                       Prompter.refinanceCalculatorPrompts(mortgage);
                       calc.display(mortgage);
                       break;
            case "3" :
                       calc = CalcFactory.createCalculator("Amortization");
                       Prompter.amortizationPrompts(mortgage);
                       calc.display(mortgage);
                       break;
            case "4" : System.exit(0);
            default:
                System.out.println("Invalid Entry!! Please select one of the entries below :");
                start();

        }
    }
}