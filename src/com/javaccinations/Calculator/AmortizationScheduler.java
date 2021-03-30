package com.javaccinations.Calculator;

import java.time.LocalDate;

public class AmortizationScheduler {
    static double balance;
    static LocalDate startDate = LocalDate.now();
    static double totalInterest = 0.0;
    static double aRate;

    public static void amortizationScheduler(String currPrinicipal, String loanterm, String rate ){
        balance = Double.parseDouble(currPrinicipal);
        aRate=Double.parseDouble(rate);
        Calculator calc = CalcFactory.createCalculator("Purchase", String.valueOf(balance), "0", loanterm, rate);
        double monthlyPayment = calc.calculate();

        System.out.printf("%14s %10s %11s %10s %16s %10s %n","Payment Date","Payment","Principal","Interest","Total Interest","Balance");
        System.out.printf("%14s %10s %11s %10s %16s %10s %n","------------","-------","---------","--------","--------------","-------");

        for (int i=0;i<(Integer.parseInt(loanterm)*12);i++)
        {
            double monthlyInterest = (balance * aRate/ 12) / 100;
            totalInterest = totalInterest + monthlyInterest;
            double prinicpalPayment = monthlyPayment - monthlyInterest;
            balance = balance - prinicpalPayment;
            startDate = startDate.plusMonths(1);
            String paymentDate = startDate.getMonth() + " " + startDate.getYear();

            System.out.printf("%14s %10s %9s %11s %13s %6s %-1s %n",
                    paymentDate,
                    roundMe2Decimals(monthlyPayment),
                    roundMe2Decimals(prinicpalPayment),
                    roundMe2Decimals(monthlyInterest),
                    roundMe2Decimals(totalInterest),
                    "", roundMe2Decimals(balance));
        }
    }

    public static double roundMe2Decimals(double number){
        return Math.round(number*100.0)/100.0;
    }

}