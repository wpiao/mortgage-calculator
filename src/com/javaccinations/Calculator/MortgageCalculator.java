package com.javaccinations.Calculator;

public class MortgageCalculator implements Calculator{

    int loanTerm;
    double homePrice, downPayment, rate;


    public MortgageCalculator(double homePrice, double downPayment, int loanTerm, double rate) {
        this.homePrice = homePrice;
        this.downPayment = downPayment;
        this.loanTerm = loanTerm;
        setRate(rate);
    }

    @Override
    public void display() {
        System.out.println("Your monthly payment = " + AmortizationScheduler.roundMe2Decimals(calculate()));
    }

    @Override
    public double calculate() {
        double monthlyRate = (rate/100)/12;
        int months = loanTerm*12;
        double principal = homePrice - downPayment;
        double result = (principal * monthlyRate)/(1 - Math.pow(1 + monthlyRate, - months));
        return result;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setHomePrice(double homePrice) {
        this.homePrice = homePrice;
    }
}