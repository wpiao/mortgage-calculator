package com.javaccinations.Calculator;

public class RefinanceCalculator implements Calculator{
    int loanTerm;
    double balance,  rate;

    public RefinanceCalculator(double lPrincipal, int loanterm, double lRate) {
        this.balance = lPrincipal;
        this.loanTerm = loanterm;
        this.rate = lRate;

    }

    @Override
    public void display() {

    }

    @Override
    public double calculate() {
        double monthlyRate = (rate/100)/12;
        int months = loanTerm*12;
        double result = (balance * monthlyRate)/(1 - Math.pow(1 + monthlyRate, - months));
        return result;
    }

    public static double calculateRemainingBalance(String origMortgageAmount, int loanterm, String origRate, double currMonthlyPayment) {

        double balance = Double.parseDouble(origMortgageAmount);
        double rate= Double.parseDouble(origRate);

        for (int i=1;i<=(loanterm*12);i++) {
            double monthlyInterest = (balance * rate / 12) / 100;
            double prinicpalPayment = currMonthlyPayment - monthlyInterest;
            balance = balance - prinicpalPayment;   // balance left to be paid
        }

        return balance;
    }
}