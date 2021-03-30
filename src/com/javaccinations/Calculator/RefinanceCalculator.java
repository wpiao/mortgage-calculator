package com.javaccinations.Calculator;

public class RefinanceCalculator implements Calculator{
    int loanTerm, paidLoanTerm;
    static double balance;
    double rate;

    double monthlyPayment;

    public RefinanceCalculator(double lPrincipal, int loanterm, double lRate, int... paidLoanTerm) {
        this.balance = lPrincipal;
        this.loanTerm = loanterm;
        this.rate = lRate;
        this.paidLoanTerm = paidLoanTerm[0];
    }

    @Override
    public void display() {

    }

    @Override
    public double calculate() {
        double monthlyRate = (rate/100)/12;
        int months = loanTerm*12;
        monthlyPayment = (balance * monthlyRate)/(1 - Math.pow(1 + monthlyRate, - months));

        setRemainingBalance();
        return  monthlyPayment;
    }

    public double setRemainingBalance() {
        for (int i=1;i<=(paidLoanTerm*12);i++) {
            double monthlyInterest = (balance * rate / 12) / 100;
            double prinicpalPayment = monthlyPayment - monthlyInterest;
            balance = balance - prinicpalPayment;   // balance left to be paid
        }
        return balance;
    }

    public static void summarizeResults(RefinanceCalculator calc1, RefinanceCalculator calc2) {

        double newMonthlyPayment = AmortizationScheduler.roundMe2Decimals(calc2.monthlyPayment);
        double oldMonthlyPayment = AmortizationScheduler.roundMe2Decimals(calc1.monthlyPayment);

        System.out.println("Your new monthly payment = " + newMonthlyPayment);
        if (newMonthlyPayment < oldMonthlyPayment)
            System.out.println("Your monthly savings is $" + (oldMonthlyPayment - newMonthlyPayment));
        else {
            System.out.println("You'll pay $" + AmortizationScheduler.roundMe2Decimals(newMonthlyPayment - oldMonthlyPayment) + " more per month");
        }
    }


    public double getBalance() {
        return balance;
    }
}