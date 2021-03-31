package com.javaccinations.utilties;

import com.javaccinations.calculator.*;

import java.util.Arrays;
import java.util.List;

public class Prompter {
    static Calculator calc;

    public static void mortgageCalculatorPrompts(Mortgage mortgage){

        System.out.println("Please enter Home Price: ");
        String homePrice = UserInput.getUserInputString();
        double dHomePrice = homePriceValidation(homePrice);
        mortgage.setHomePrice(dHomePrice);

        System.out.println("Please enter Down Payment: ");
        String downPayment = UserInput.getUserInputString();
        double dDownPayment = downPaymentValidation(downPayment, dHomePrice);
        mortgage.setDownPayment(dDownPayment);

        System.out.println("Please enter the Loan Term: ");
        termPrompt();
        String loanTerm = UserInput.getUserInputString();
        int iLoanTerm = loanTermValidation(loanTerm);
        mortgage.setLoanTerm(iLoanTerm);

        System.out.println("Please enter the Loan Interest Rate: ");
        String rate = UserInput.getUserInputString();
        double dRate = rateValidation(rate);
        mortgage.setRate(dRate);

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
                "   Enter 4 to Exit\n");
    }

    public static void termPrompt(){
        System.out.println(
                "   Year - " + LoanTerm.FIFTEEN_YEAR.getLoanTerm() + "\n" +
                        "   Year - " + LoanTerm.THIRTY_YEAR.getLoanTerm() + "\n" +
                        "   Exit\n");
    }

    public static void namePrompt() {
        System.out.println("Please enter your name to start the application:");
        System.out.print("> ");
        System.out.println("Hello " + UserInput.getUserInputString());
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
                System.out.println("You entered invalid input. Please enter a positive number for the home price.\n");
                System.out.println("Please enter Home Price: ");
                homePrice = UserInput.getUserInputString();
            }
        } catch (IllegalUserInputException e) {
            e.getMessage();
        }
        return Double.parseDouble(homePrice);
    }

    private static double downPaymentValidation(String downPayment, double dHomePrice) {
        try {
            while(!numberOrNot(downPayment) || Double.parseDouble(downPayment) < 0.0 || Double.parseDouble(downPayment) > dHomePrice) {
                System.out.println("Please enter a valid down payment. Down payment has be be less than the home price.\n");
                System.out.println("Please enter Down Payment: ");
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
                System.out.println("You entered invalid input. Please enter 15 or 30.\n");
                System.out.println("Please enter a Loan Term: ");
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
                System.out.println("You entered invalid input. Please enter a positive loan interest rate.\n");
                System.out.println("Please enter a Loan Interest Rate: ");
                rate = UserInput.getUserInputString();
            }
        } catch (IllegalUserInputException e) {
            e.getMessage();
        }
        return Double.parseDouble(rate);
    }
}