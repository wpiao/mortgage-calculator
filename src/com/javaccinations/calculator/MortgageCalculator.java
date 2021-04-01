package com.javaccinations.calculator;

import static com.javaccinations.utilties.Rounding.roundMe2Decimals;

public class MortgageCalculator implements Calculator{

    @Override
    public void display(Mortgage mortgage) {
        System.out.println("Your monthly payment = $" + roundMe2Decimals(calculate(mortgage)));
    }

    @Override
    public double calculate(Mortgage mortgage) {
        double monthlyRate = (mortgage.getRate()/100)/12;
        int months = mortgage.getLoanTerm()*12;
        double principal = mortgage.getHomePrice() - mortgage.getDownPayment();
        double result = (principal * monthlyRate)/(1 - Math.pow(1 + monthlyRate, - months));
        return result;
    }

}