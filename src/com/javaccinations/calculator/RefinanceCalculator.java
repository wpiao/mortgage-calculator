package com.javaccinations.calculator;

import java.time.LocalDate;
import static com.javaccinations.utilties.Rounding.roundMe2Decimals;

public class RefinanceCalculator implements Calculator{
   static double oldMonthlyPayment, newMonthlyPayment;
   static double oldTotalInterest=0, newTotalInterest=0;

    @Override
    public void display(Mortgage mortgage) {
    calculateNewPrincipal(mortgage);
    }

    public void calculateNewPrincipal(Mortgage mortgage) {
        int paidLoanTerm =(LocalDate.now().getYear()-mortgage.getOriginationYear()); //number of yrs the borrower has been paying mortgage
        double balance = mortgage.getPrincipal();
        double rate = mortgage.getRate();

        double monthlyRate = (rate/100)/12;
        int months = mortgage.getLoanTerm()*12;
        oldMonthlyPayment = (balance * monthlyRate)/(1 - Math.pow(1 + monthlyRate, - months));

        for (int i=1;i<=(paidLoanTerm*12);i++) {
            double monthlyInterest = (balance * rate / 12) / 100;
            double principalPayment = oldMonthlyPayment - monthlyInterest;
            balance = balance - principalPayment;   // balance left to be paid
        }
        mortgage.setPrincipal(balance);
        calculate(mortgage);
        caculateTotalInterests(mortgage);
    }

    public double calculate(Mortgage mortgage) {
        double monthlyRate = (mortgage.getNewRate()/100)/12;
        int months = mortgage.getNewLoanTerm() *12;
        newMonthlyPayment = (mortgage.getPrincipal() * monthlyRate)/(1 - Math.pow(1 + monthlyRate, - months));

        return  newMonthlyPayment;
    }

     public void caculateTotalInterests(Mortgage mortgage){
         int unPaidLoanTerm = mortgage.getLoanTerm() - LocalDate.now().getYear();
         double balance = mortgage.getPrincipal();

         for (int i=1;i<=(unPaidLoanTerm*12);i++) {
             double monthlyInterest = (balance * mortgage.getRate() / 12) / 100;
             oldTotalInterest = oldTotalInterest + monthlyInterest;
             double principalPayment = oldMonthlyPayment - monthlyInterest;
             balance = balance - principalPayment;   // balance left to be paid
         }
         balance = mortgage.getPrincipal();
         for (int i=1;i<=(mortgage.getNewLoanTerm()*12);i++) {
             double monthlyInterest = (balance * mortgage.getNewRate() / 12) / 100;
             newTotalInterest = newTotalInterest + monthlyInterest;
             double principalPayment = newMonthlyPayment - monthlyInterest;
             balance = balance - principalPayment;   // balance left to be paid
         }
         summarizeResults();
     }

    public static void summarizeResults() {
        System.out.println("New monthly payment = " + roundMe2Decimals(newMonthlyPayment));
        System.out.println("Old monthly payment = " + roundMe2Decimals(oldMonthlyPayment));
        if (newMonthlyPayment < oldMonthlyPayment)
            System.out.println("Your monthly savings is $" + roundMe2Decimals(oldMonthlyPayment - newMonthlyPayment));
        else {
            System.out.println("You'll pay $" + roundMe2Decimals(newMonthlyPayment - oldMonthlyPayment) + " more per month");
        }

        if (newTotalInterest<oldTotalInterest)
            System.out.println("However, if you refinance you’ll pay $" +roundMe2Decimals(oldTotalInterest-newTotalInterest) + "less on your mortgage interest.");
        else
            System.out.println("if you refinance you’ll pay $" +roundMe2Decimals(newTotalInterest-oldTotalInterest) + "less on your mortgage interest.");
    }
}