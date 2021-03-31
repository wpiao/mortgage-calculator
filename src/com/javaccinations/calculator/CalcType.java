package com.javaccinations.calculator;

public enum CalcType {
    PURCHASE  ("purchase"),
    REFINANCE ("refinance"),
    AMORTIZATION ("amortization");

    private String calcType;

    CalcType(String type) {
        this.calcType = type;
    }
}
