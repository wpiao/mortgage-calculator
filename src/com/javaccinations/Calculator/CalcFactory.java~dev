package com.javaccinations.Calculator;

import com.javaccinations.client.CalculatorClient;

public class CalcFactory {

    public CalcFactory() {
    }

    public static Calculator createCalculator(String type, String homePrice, String downPayment, String loanTerm, String rate) {
        Calculator calc = null;
        int t = 0;
        for (LoanTerm lt : LoanTerm.values()){
            if(lt.getLoanTerm().equals(loanTerm)){
                t = Integer.parseInt(lt.getLoanTerm());
            }
        }

        double lRate = Double.parseDouble(rate);
        double lPrincipal = Double.parseDouble(homePrice);
        double dPayment = Double.parseDouble(downPayment);
        switch (type){
            case "1":
                calc = new MortgageCalculator(CalcType.PURCHASE, lPrincipal, dPayment, t, lRate);
                break;
            case "2":
                calc = new RefinanceCalculator();
                break;
            default:
                throw new IllegalArgumentException("Invalid type: "
                        + type + " needs to be valid");
        }
        return calc;
    }
}