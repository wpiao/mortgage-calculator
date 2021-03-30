package com.javaccinations.Calculator;

import com.javaccinations.client.CalculatorClient;

public class CalcFactory {

    public CalcFactory() {
    }

    public static Calculator createCalculator(String type, String homePrice, String downPayment, String loanTerm, String rate,int... paidLoanTerm) {
        Calculator calc = null;
        int lTerm = 0;
        for (LoanTerm lt : LoanTerm.values()){
            if(lt.getLoanTerm().equals(loanTerm)){
                lTerm = Integer.parseInt(lt.getLoanTerm());
            }
        }

        double lRate = Double.parseDouble(rate);
        double lPrincipal = Double.parseDouble(homePrice);
        double dPayment = Double.parseDouble(downPayment);
        switch (type){
            case "Purchase":
                calc = new MortgageCalculator(lPrincipal, dPayment, lTerm, lRate);
                break;
            case "Refinance":
                calc = new RefinanceCalculator(lPrincipal,lTerm,lRate,paidLoanTerm);
                break;
            default:
                throw new IllegalArgumentException("Invalid type: "
                        + type + " needs to be valid");
        }
        return calc;
    }
}