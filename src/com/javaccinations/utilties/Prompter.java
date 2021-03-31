package com.javaccinations.utilties;

import com.javaccinations.calculator.*;

public class Prompter {
    public static void mortgageCalculatorPrompts(Mortgage mortgage){

        System.out.print("Please enter Home Price: \n> ");
        mortgage.setHomePrice(UserInput.getUserInputDouble());

        System.out.print("Please enter Down Payment: \n> ");
        mortgage.setDownPayment(UserInput.getUserInputDouble());

        System.out.println("Please enter the Loan Term: ");
        termPrompt();
        System.out.print("> ");
        mortgage.setLoanTerm(UserInput.getUserInputInteger());

        System.out.print("Please enter the Loan Interest Rate: \n> ");
        mortgage.setRate(UserInput.getUserInputDouble());

    }

    public static void amortizationPrompts(Mortgage mortgage){

        System.out.print("Please enter your mortgage amount: \n> ");
        mortgage.setPrincipal(UserInput.getUserInputDouble());

        System.out.println("Please enter your mortgage term: ");
        termPrompt();
        System.out.print("> ");
        mortgage.setLoanTerm(UserInput.getUserInputInteger());

        System.out.print("Please enter your Mortgage Interest Rate: \n> ");
        mortgage.setRate(UserInput.getUserInputDouble());
    }

    public static void refinanceCalculatorPrompts (Mortgage mortgage) {

        System.out.print("Please enter your original mortgage amount: \n> ");
        mortgage.setPrincipal(UserInput.getUserInputDouble());

        System.out.println("Please enter your original mortgage term: ");
        termPrompt();
        System.out.print("> ");
        mortgage.setLoanTerm(UserInput.getUserInputInteger());

        System.out.print("Please enter your original Mortgage Interest Rate: \n> ");
        mortgage.setRate(UserInput.getUserInputDouble());

        System.out.print("Please enter your initial origination year: \n> ");
        mortgage.setOriginationYear(UserInput.getUserInputInteger());

        System.out.println("Please enter your new mortgage term: ");
        termPrompt();
        System.out.print("> ");
        mortgage.setNewLoanTerm(UserInput.getUserInputInteger());

        System.out.print("Please enter your new Mortgage Interest Rate: \n> ");
        mortgage.setNewRate(UserInput.getUserInputDouble());
    }

    public static void calcPrompt(){
        System.out.println(
                "   Enter 1 for Purchase\n" +
                "   Enter 2 for Refinance\n" +
                "   Enter 3 for Amortization Schedule\n" +
                "   Enter 4 to Exit");
    }

    public static void termPrompt(){
        System.out.println(
                "   Year - " + LoanTerm.FIFTEEN_YEAR.getLoanTerm() + "\n" +
                        "   Year - " + LoanTerm.THIRTY_YEAR.getLoanTerm());
    }
}