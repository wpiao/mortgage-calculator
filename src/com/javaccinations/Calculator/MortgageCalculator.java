package com.javaccinations.Calculator;

public class MortgageCalculator implements Calculator{
    CalcType type;
    int loanTerm;
    double homePrice, downPayment, rate;


    public MortgageCalculator(CalcType type, double homePrice, double downPayment, int loanTerm, double rate) {
        this.type = type;
        this.homePrice = homePrice;
        this.downPayment = downPayment;
        this.loanTerm = loanTerm;
        setRate(rate);
    }

    @Override
    public void display() {

    }

    @Override
    public double calculate() {
        System.out.println("Mortgage Calculator Prints");
        double monthlyRate = (rate/100)/12;
        int months = loanTerm*12;
        double principal = homePrice - downPayment;
        double result = Math.round((principal * monthlyRate)/(1 - Math.pow(1 + monthlyRate, - months)));
        System.out.println(result);
        return result;
    }

    public void setType(CalcType type) {
        this.type = type;
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