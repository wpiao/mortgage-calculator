package com.javaccinations.calculator;

import java.time.LocalDate;
import static com.javaccinations.utilties.Rounding.roundMe2Decimals;

public class RefinanceCalculator implements Calculator{
   static double oldMonthlyPayment, newMonthlyPayment;
   static double oldTotalInterest, newTotalInterest;
   int oldLoanTerm;
   double oldRate;
   static final String ANSI_RESET = "\u001B[0m";
   static final String ANSI_RED = "\u001B[31m";
   static final String ANSI_GREEN = "\u001B[32m";

    @Override
    public void display(Mortgage mortgage) {
    calculateNewPrincipal(mortgage);
    }

    public void calculateNewPrincipal(Mortgage mortgage) {
        int paidLoanTerm =(LocalDate.now().getYear()-mortgage.getOriginationYear()); //number of yrs the borrower has been paying mortgage
        double balance = mortgage.getPrincipal();
        oldMonthlyPayment = calculate(mortgage);

        for (int i=1;i<=(paidLoanTerm*12);i++) {
            double monthlyInterest = (balance * mortgage.getRate() / 12) / 100;
            double principalPayment = oldMonthlyPayment - monthlyInterest;
            balance = balance - principalPayment;   // balance left to be paid
        }

        mortgage.setPrincipal(balance);
        oldRate=mortgage.getRate();
        mortgage.setRate(mortgage.getNewRate());
        oldLoanTerm=mortgage.getLoanTerm();
        mortgage.setLoanTerm(mortgage.getNewLoanTerm());

        newMonthlyPayment = calculate(mortgage);
        caculateTotalInterests(mortgage);
    }

        public double calculate(Mortgage mortgage) {
        double monthlyRate = (mortgage.getRate()/100)/12;
        int months = mortgage.getLoanTerm() *12;
        double result = (mortgage.getPrincipal() * monthlyRate)/(1 - Math.pow(1 + monthlyRate, - months));

        return  result;
    }

     public void caculateTotalInterests(Mortgage mortgage){

        //calculate total interest on the old loan(from current date to end of loan term)
         int unPaidLoanTerm = oldLoanTerm - (LocalDate.now().getYear()-mortgage.getOriginationYear());
         double balance = mortgage.getPrincipal();

         for (int i=1;i<=(unPaidLoanTerm*12);i++) {
             double monthlyInterest = (balance * oldRate / 12) / 100;
             oldTotalInterest = oldTotalInterest + monthlyInterest;
             double principalPayment = oldMonthlyPayment - monthlyInterest;
             balance = balance - principalPayment;   // balance left to be paid
         }

         //calculate total interest on the new loan for the whole loan term)
         balance = mortgage.getPrincipal();
         for (int i=1;i<=(mortgage.getNewLoanTerm()*12);i++) {
             double monthlyInterest = (balance * mortgage.getNewRate() / 12) / 100;
             newTotalInterest = newTotalInterest + monthlyInterest;
             double principalPayment = newMonthlyPayment - monthlyInterest;
             balance = balance - principalPayment;   // balance left to be paid
         }
         System.out.println("Current Loan Balance = $" + roundMe2Decimals(mortgage.getPrincipal()));
         summarizeResults();
     }

    public static void summarizeResults() {

        System.out.println("New monthly payment = $" + roundMe2Decimals(newMonthlyPayment));
        System.out.println("Old monthly payment = $" + roundMe2Decimals(oldMonthlyPayment));
        double monthlySavings = roundMe2Decimals(oldMonthlyPayment - newMonthlyPayment);
        System.out.println("Monthly Savings = $ " + monthlySavings);

        if (newMonthlyPayment < oldMonthlyPayment)
            System.out.println(ANSI_GREEN + "Your monthly savings is $" + monthlySavings + ANSI_RESET);
        else {
            System.out.println(ANSI_RED + "You'll pay $" + (-1*monthlySavings) + " more per month." + ANSI_RESET);
        }
        if (newTotalInterest<oldTotalInterest)
            System.out.println(ANSI_GREEN + "However, if you refinance you’ll pay $" +roundMe2Decimals(oldTotalInterest-newTotalInterest)
                    + " less on your mortgage interest." + ANSI_RESET);
        else
            System.out.println(ANSI_RED + "If you refinance you’ll pay $" +roundMe2Decimals(newTotalInterest-oldTotalInterest)
                    + " more on your mortgage interest." + ANSI_RESET);
    }
}