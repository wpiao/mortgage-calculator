package com.javaccinations.calculator;

import java.time.LocalDate;
import static com.javaccinations.utilties.Rounding.roundMe2Decimals;

public class AmortizationCalculator implements Calculator {

    @Override
    public void display(Mortgage mortgage) {
        System.out.printf("%14s %10s %11s %10s %16s %10s %n", "Payment Date", "Payment", "Principal", "Interest", "Total Interest", "Balance");
        System.out.printf("%14s %10s %11s %10s %16s %10s %n", "------------", "-------", "---------", "--------", "--------------", "-------");

        double monthlyPayment = calculate(mortgage);
        double balance = mortgage.getPrincipal();
        LocalDate startDate = LocalDate.now();
        double totalInterest = 0.0;

        for (int i = 0; i < (mortgage.getLoanTerm() * 12); i++) {
            double monthlyInterest = (balance * mortgage.getRate() / 12) / 100;
            totalInterest = totalInterest + monthlyInterest;
            double principalPayment = monthlyPayment - monthlyInterest;
            balance = balance - principalPayment;
            startDate = startDate.plusMonths(1);
            String paymentDate = startDate.getMonth() + " " + startDate.getYear();

            System.out.printf("%14s %10s %9s %11s %13s %6s %-1s %n",
                    paymentDate,
                    roundMe2Decimals(monthlyPayment),
                    roundMe2Decimals(principalPayment),
                    roundMe2Decimals(monthlyInterest),
                    roundMe2Decimals(totalInterest),
                    "", roundMe2Decimals(balance));
        }
    }

    @Override
    public double calculate(Mortgage mortgage) {
        double monthlyRate = (mortgage.getRate() / 100) / 12;
        int months = mortgage.getLoanTerm() * 12;
        double result = (mortgage.getPrincipal() * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
        return result;
    }
}
