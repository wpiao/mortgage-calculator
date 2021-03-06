package com.javaccinations.utilties;

import com.javaccinations.calculator.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Prompter {
    static Calculator calc;

    public static void namePrompt() {
        System.out.println("\n********* Welcome to the Mortgage Calculator ********** \n");
        System.out.print("Please enter your name to start the application: \n> ");
        System.out.println("\nHello " + UserInput.getUserInputString() + "!!\n");
    }

    public static void typePrompt() {
        System.out.println("Please select a Calculator: ");
        calcPrompt();
        String type = UserInput.getUserInputString();
        try {
            List<String> allowedType = Arrays.asList("1", "2", "3", "4");
            while (!allowedType.contains(type)) {
                System.out.println("You entered invalid input: " + type + ". Please 1 or 2 or 3 or 4 to select the mortgage type.");
                calcPrompt();
                type = UserInput.getUserInputString();
            }
        } catch (IllegalUserInputException e) {
            e.getMessage();
        }
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
        }
    }

    public static void calcPrompt(){
        System.out.println(
                "   Enter 1 for Purchase\n" +
                        "   Enter 2 for Refinance\n" +
                        "   Enter 3 for Amortization Schedule\n" +
                        "   Enter 4 to Exit");
    }

    public static void mortgageCalculatorPrompts(Mortgage mortgage){

        System.out.print("Please enter Home Price: \n> ");
        String homePrice = UserInput.getUserInputString();
        double dHomePrice = homePriceValidation(homePrice);
        mortgage.setHomePrice(dHomePrice);

        System.out.print("Please enter Down Payment: \n> ");
        String downPayment = UserInput.getUserInputString();
        double dDownPayment = downPaymentValidation(downPayment, dHomePrice);
        mortgage.setDownPayment(dDownPayment);

        System.out.println("Please enter the Loan Term: ");
        termPrompt();
        System.out.print("> ");
        String loanTerm = UserInput.getUserInputString();
        int iLoanTerm = loanTermValidation(loanTerm);
        mortgage.setLoanTerm(iLoanTerm);

        System.out.print("Please enter the Loan Interest Rate: \n> ");
        String rate = UserInput.getUserInputString();
        double dRate = rateValidation(rate);
        mortgage.setRate(dRate);
    }

    public static void amortizationPrompts(Mortgage mortgage){

        System.out.print("Please enter your mortgage amount: \n> ");
        String mortgageAmount = UserInput.getUserInputString();
        double dMortgageAmount = mortgageAmountValidation(mortgageAmount);
        mortgage.setPrincipal(dMortgageAmount);

        System.out.println("Please enter your mortgage term: ");
        termPrompt();
        System.out.print("> ");
        String loanTerm = UserInput.getUserInputString();
        int iLoanTerm = loanTermValidation(loanTerm);
        mortgage.setLoanTerm(iLoanTerm);

        System.out.print("Please enter your Mortgage Interest Rate: \n> ");
        String rate = UserInput.getUserInputString();
        double dRate = rateValidation(rate);
        mortgage.setRate(dRate);
    }

    public static void refinanceCalculatorPrompts (Mortgage mortgage) {

        System.out.print("Please enter your original mortgage amount: \n> ");
        String mortgageAmount = UserInput.getUserInputString();
        double dMortgageAmount = mortgageAmountValidation(mortgageAmount);
        mortgage.setPrincipal(dMortgageAmount);

        System.out.println("Please enter your original mortgage term: ");
        termPrompt();
        System.out.print("> ");
        String originalLoanTerm = UserInput.getUserInputString();
        int iOriginalLoanTerm = loanTermValidation(originalLoanTerm);
        mortgage.setLoanTerm(iOriginalLoanTerm);

        System.out.print("Please enter your original Mortgage Interest Rate: \n> ");
        String originalRate = UserInput.getUserInputString();
        double dOriginalRate = rateValidation(originalRate);
        mortgage.setRate(dOriginalRate);

        System.out.print("Please enter your initial origination year: \n> ");
        String year = UserInput.getUserInputString();
        int iYear = yearValidation(year);
        mortgage.setOriginationYear(iYear);

        System.out.println("Please enter your new mortgage term: ");
        termPrompt();
        System.out.print("> ");
        String newLoanTerm = UserInput.getUserInputString();
        int iNewLoanTerm = loanTermValidation(newLoanTerm);
        mortgage.setNewLoanTerm(iNewLoanTerm);

        System.out.print("Please enter your new Mortgage Interest Rate: \n> ");
        String newRate = UserInput.getUserInputString();
        double dNewRate = rateValidation(newRate);
        mortgage.setNewRate(dNewRate);
    }
   
    public static void termPrompt(){
        System.out.println(
                "   Year - " + LoanTerm.FIFTEEN_YEAR.getLoanTerm() + "\n" +
                        "   Year - " + LoanTerm.THIRTY_YEAR.getLoanTerm());
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

    private static double homePriceValidation(String homePrice) {
        try {
            while(!numberOrNot(homePrice) || Double.parseDouble(homePrice) <= 0) {
                System.out.println("\nYou entered invalid input. Please enter a positive number for the home price.");
                System.out.print("Please enter Home Price: \n> ");
                homePrice = UserInput.getUserInputString();
            }
        } catch (IllegalUserInputException e) {
            e.getMessage();
        }
        return Double.parseDouble(homePrice);
    }

    private static double mortgageAmountValidation(String mortgageAmount) {
        try {
            while(!numberOrNot(mortgageAmount) || Double.parseDouble(mortgageAmount) <= 0) {
                System.out.println("\nYou entered invalid input. Please enter a positive number for mortgage amount.");
                System.out.print("Please enter Mortgage Amount: \n> ");
                mortgageAmount = UserInput.getUserInputString();
            }
        } catch (IllegalUserInputException e) {
            e.getMessage();
        }
        return Double.parseDouble(mortgageAmount);
    }

    private static double downPaymentValidation(String downPayment, double dHomePrice) {
        try {
            while(!numberOrNot(downPayment) || Double.parseDouble(downPayment) < 0.0 || Double.parseDouble(downPayment) > dHomePrice) {
                System.out.println("\nPlease enter a valid down payment. Down payment has be be less than the home price.");
                System.out.print("Please enter Down Payment: \n> ");
                downPayment = UserInput.getUserInputString();
            }
        } catch (IllegalUserInputException e) {
            e.getMessage();
        }
        return Double.parseDouble(downPayment);
    }

    private static int loanTermValidation(String loanTerm) {
        List<String> allowedLoanTerm = Arrays.asList("15", "30");
        try {
            while (!allowedLoanTerm.contains(loanTerm)) {
                System.out.println("\nYou entered invalid input. Please enter 15 or 30.");
                System.out.println("Please enter a Loan Term: ");
                termPrompt();
                System.out.print("> ");
                loanTerm = UserInput.getUserInputString();
            }
        } catch (IllegalUserInputException e) {
            e.getMessage();
        }
        return Integer.parseInt(loanTerm);
    }

    private static double rateValidation(String rate) {
        try {
            while (!numberOrNot(rate) || Double.parseDouble(rate) <= 0.0) {
                System.out.println("\nYou entered invalid input. Please enter a positive loan interest rate.");
                System.out.print("Please enter a Loan Interest Rate: \n> ");
                rate = UserInput.getUserInputString();
            }
        } catch (IllegalUserInputException e) {
            e.getMessage();
        }
        return Double.parseDouble(rate);
    }

    private static int yearValidation(String year) {
        try {
            while(!numberOrNot(year) || Integer.parseInt(year) < 0 || Integer.parseInt(year) > LocalDate.now().getYear()) {
                System.out.println("\nYou entered invalid input. The input year has to be earlier than current year.");
                System.out.print("Please enter your initial origination year: \n> ");
                year = UserInput.getUserInputString();
            }
        } catch (IllegalUserInputException e) {
            e.getMessage();
        }
        return Integer.parseInt(year);
    }
}