package com.javaccinations.utilties;

import com.javaccinations.calculator.*;

public class Prompter {
    public static void mortgageCalculatorPrompts(Mortgage mortgage){

        System.out.println("Please enter Home Price: ");
        mortgage.setHomePrice(UserInput.getUserInputDouble());

        System.out.println("Please enter Down Payment: ");
        mortgage.setDownPayment(UserInput.getUserInputDouble());

        System.out.println("Please enter the Loan Term: ");
        termPrompt();
        mortgage.setLoanTerm(UserInput.getUserInputInteger());

        System.out.println("Please enter the Loan Interest Rate: ");
        mortgage.setRate(UserInput.getUserInputDouble());

    }

    public static void amortizationPrompts(Mortgage mortgage){

        System.out.println("Please enter your mortgage amount: ");
        mortgage.setPrincipal(UserInput.getUserInputDouble());

        System.out.println("Please enter your mortgage term: ");
        termPrompt();
        mortgage.setLoanTerm(UserInput.getUserInputInteger());

        System.out.println("Please enter your Mortgage Interest Rate: ");
        mortgage.setRate(UserInput.getUserInputDouble());
    }

    public static void refinanceCalculatorPrompts (Mortgage mortgage) {

        System.out.println("Please enter your original mortgage amount: ");
        mortgage.setPrincipal(UserInput.getUserInputDouble());

        System.out.println("Please enter your original mortgage term: ");
        termPrompt();
        mortgage.setLoanTerm(UserInput.getUserInputInteger());

        System.out.println("Please enter your original Mortgage Interest Rate: ");
        mortgage.setRate(UserInput.getUserInputDouble());

        System.out.println("Please enter your initial origination year: ");
        mortgage.setOriginationYear(UserInput.getUserInputInteger());

        System.out.println("Please enter your new mortgage term: ");
        termPrompt();
        mortgage.setNewLoanTerm(UserInput.getUserInputInteger());

        System.out.println("Please enter your new Mortgage Interest Rate: ");
        mortgage.setNewRate(UserInput.getUserInputDouble());
    }

    public static void calcPrompt(){
        System.out.println(
                "   Enter 1 for Purchase\n" +
                "   Enter 2 for Refinance\n" +
                "   Enter 3 for Amortization Schedule\n" +
                "   Enter 4 to Exit\n");
    }

    public static void termPrompt(){
        System.out.println(
                "   Year - " + LoanTerm.FIFTEEN_YEAR.getLoanTerm() + "\n" +
                        "   Year - " + LoanTerm.THIRTY_YEAR.getLoanTerm() + "\n" +
                        "   Exit\n");
    }
}