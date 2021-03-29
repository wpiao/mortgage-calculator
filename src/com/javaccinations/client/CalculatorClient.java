package com.javaccinations.client;

import com.javaccinations.Calculator.CalcFactory;
import com.javaccinations.Calculator.Calculator;
import com.javaccinations.Calculator.LoanTerm;
import com.javaccinations.utilties.UserInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<String> allowedType = Arrays.asList("1", "2", "3");
        while(!allowedType.contains(type)) {
            System.out.println("You entered invalid input: " + type + ". Please enter 1 or 2 or 3!");
            calcPrompt();
            type = UserInput.getUserInput();
        }

        System.out.println("Please enter Home Price: ");
        String homePrice = UserInput.getUserInput();

        System.out.println("Please enter Down Payment: ");
        String downPayment = UserInput.getUserInput();
        while(Double.parseDouble(downPayment) > Double.parseDouble(homePrice)) {
            System.out.println("Your entered home price was " + homePrice + " and down payment was " + downPayment
            + ". Down payment cannot be larger than home price. Please enter a valid down payment.");
            downPayment = UserInput.getUserInput();
        }

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
                "   Enter 15 for " + LoanTerm.FIFTEEN_YEAR.getLoanTerm() + "-Year Fixed\n" +
                "   Enter 30 for " + LoanTerm.THIRTY_YEAR.getLoanTerm() + "-Year Fixed\n" +
                "   Exit\n");
    }
}