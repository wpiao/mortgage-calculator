package com.javaccinations.client;

import com.javaccinations.Calculator.CalcFactory;
import com.javaccinations.Calculator.Calculator;
import com.javaccinations.Calculator.IllegalUserInputException;
import com.javaccinations.Calculator.LoanTerm;
import com.javaccinations.utilties.UserInput;

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
        try {
            List<String> allowedType = Arrays.asList("1", "2", "3");
            while (!allowedType.contains(type)) {
                System.out.println("You entered invalid input: " + type + ". Please enter 1 or 2 or 3 to select the mortgage type.\n");
                calcPrompt();
                type = UserInput.getUserInput();
            }
        } catch (IllegalUserInputException e) {
            e.getMessage();
        }

        System.out.println("Please enter Home Price: ");
        String homePrice = UserInput.getUserInput();
        try {
            while (!numberOrNot(homePrice) || Double.parseDouble(homePrice) <= 0.0) {
                System.out.println("You entered invalid input. Please enter a positive number for the home price.\n");
                System.out.println("Please enter Home Price: ");
                homePrice = UserInput.getUserInput();
            }
        } catch (IllegalUserInputException e) {
            e.getMessage();
        }

        System.out.println("Please enter Down Payment: ");
        String downPayment = UserInput.getUserInput();
        try {
            while (!numberOrNot(downPayment) || Double.parseDouble(downPayment) <= 0.0 || Double.parseDouble(downPayment) > Double.parseDouble(homePrice)) {
                System.out.println("Please enter a valid down payment. Down payment has to be less than the home price.\n");
                System.out.println("Please enter Down Payment: ");
                downPayment = UserInput.getUserInput();
            }
        } catch (IllegalUserInputException e) {
            e.getMessage();
        }

        System.out.println("Please enter a Loan Term: ");
        termPrompt();
        String loanTerm = UserInput.getUserInput();
        List<String> allowedLoanTerm = Arrays.asList("15", "30");
        try {
            while (!allowedLoanTerm.contains(loanTerm)) {
                System.out.println("You entered invalid input. Please enter 15 or 30.\n");
                System.out.println("Please enter a Loan Term: ");
                loanTerm = UserInput.getUserInput();
            }
        } catch (IllegalUserInputException e) {
            e.getMessage();
        }

        System.out.println("Please enter a Loan Interest Rate: ");
        String rate = UserInput.getUserInput();
        try {
            while (!numberOrNot(rate) || Double.parseDouble(rate) <= 0.0) {
                System.out.println("You entered invalid input. Please enter a positive loan interest rate.\n");
                System.out.println("Please enter a Loan Interest Rate: ");
                rate = UserInput.getUserInput();
            }
        } catch (IllegalUserInputException e) {
            e.getMessage();
        }

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

    private static boolean numberOrNot(String input) {
        boolean result = true;
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
    }
}