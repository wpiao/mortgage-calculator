package com.javaccinations.calculator;

public class CalcFactory {

    private CalcFactory() {
    }

    public static Calculator createCalculator(String type) {
        Calculator calc = null;
        switch (type) {
            case "Purchase":
                calc = new MortgageCalculator();
                break;
            case "Refinance":
                calc = new RefinanceCalculator();
                break;
            case "Amortization":
                calc = new AmortizationCalculator();
                break;
            default:
                throw new IllegalArgumentException("Invalid type: "
                        + type + " needs to be valid");
        }
        return calc;
    }
}