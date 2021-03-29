package com.javaccinations.client;

import com.javaccinations.Calculator.CalcFactory;
import com.javaccinations.Calculator.Calculator;
import com.javaccinations.Calculator.LoanTerm;
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
        calcPrompt();
        String type = UserInput.getUserInput();

        System.out.println("Please enter Home Price: ");
        String homePrice = UserInput.getUserInput();

        System.out.println("Please enter Down Payment: ");
        String downPayment = UserInput.getUserInput();

        System.out.println("Please enter a Loan Term: ");
        termPrompt();
        String loanTerm = UserInput.getUserInput();

        System.out.println("Please enter a Loan Interest Rate: ");
        String rate = UserInput.getUserInput();

        calc = CalcFactory.createCalculator(type, homePrice, downPayment, loanTerm, rate);
        calc.calculate();
    }

    public static void calcPrompt(){
        System.out.println(
                "   Enter 1 for Purchase\n" +
                "   Enter 2 for Refinance\n" +
                "   Enter 3 to Exit\n");
    }

    public static void termPrompt(){
        System.out.println(
                "   Year - " + LoanTerm.FIFTEEN_YEAR.getLoanTerm() + "\n" +
                        "   Year - " + LoanTerm.THIRTY_YEAR.getLoanTerm() + "\n" +
                        "   Exit\n");
    }
}