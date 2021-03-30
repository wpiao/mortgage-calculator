package com.javaccinations.utilties;

import com.javaccinations.Calculator.*;
import java.time.LocalDate;


public class Prompter {
    public static Calculator mortgageCalculatorPrompts(){
        System.out.println("Please enter Home Price: ");
        String homePrice = UserInput.getUserInput();

        System.out.println("Please enter Down Payment: ");
        String downPayment = UserInput.getUserInput();

        System.out.println("Please enter a Loan Term: ");
        termPrompt();
        String loanTerm = UserInput.getUserInput();

        System.out.println("Please enter a Loan Interest Rate: ");
        String rate = UserInput.getUserInput();

        Calculator calc = CalcFactory.createCalculator("Purchase", homePrice, downPayment, loanTerm, rate);
        calc.calculate();
        calc.display();
        return CalcFactory.createCalculator("Purchase", homePrice, downPayment, loanTerm, rate);
    }

    public static void amortizationPrompts(){
        System.out.println("Please enter your mortgage amount: ");
        String mortgageAmount = UserInput.getUserInput();

        System.out.println("Please enter your mortgage term: ");
        termPrompt();
        String loanTerm = UserInput.getUserInput();

        System.out.println("Please enter your Mortgage Interest Rate: ");
        String rate = UserInput.getUserInput();
        AmortizationScheduler.amortizationScheduler(mortgageAmount, loanTerm, rate);

    }

    public static Calculator refinanceCalculatorPrompts(){
        System.out.println("Please enter your original mortgage amount: ");
        String origMortgageAmount = UserInput.getUserInput();

        System.out.println("Please enter your original mortgage term: ");
        termPrompt();
        String origTerm = UserInput.getUserInput();


        System.out.println("Please enter your original Mortgage Interest Rate: ");
        String origRate = UserInput.getUserInput();

        System.out.println("Please enter your initial origination year: ");
        String origYear = UserInput.getUserInput();
        int effectiveLoanTerm = LocalDate.now().getYear() -Integer.parseInt(origYear);  //number of yrs the borrower has been paying mortgage

        Calculator calc = CalcFactory.createCalculator("Refinance", origMortgageAmount, "0", origTerm, origRate);
        double currMonthlyPayment = calc.calculate();
        double balance = RefinanceCalculator.calculateRemainingBalance(origMortgageAmount,effectiveLoanTerm,origRate,currMonthlyPayment);


        //pass the balance and the new term, rate for "REFINANCE"
        System.out.println("Please enter your new mortgage term: ");
        termPrompt();
        String newTerm = UserInput.getUserInput();

        System.out.println("Please enter your new Mortgage Interest Rate: ");
        String newRate = UserInput.getUserInput();
        Calculator calc2 = CalcFactory.createCalculator("Refinance", String.valueOf(balance), "0", newTerm, newRate);
        double newMonthlyPayment =calc2.calculate();

        System.out.println("Your new monthly payment = " + AmortizationScheduler.roundMe2Decimals(newMonthlyPayment));
        if(newMonthlyPayment<currMonthlyPayment)
            System.out.println("Your monthly savings is $" + AmortizationScheduler.roundMe2Decimals(currMonthlyPayment - newMonthlyPayment));
        else{
            System.out.println("You'll pay $" + AmortizationScheduler.roundMe2Decimals(newMonthlyPayment - currMonthlyPayment)+ " more per month");
        }

        return calc2 ;

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