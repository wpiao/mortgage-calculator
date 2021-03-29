package com.javaccinations.Calculator;

public enum CalcType {
    PURCHASE  ("purchase"),
    REFINANCE ("refinance");

    private String calcType;

    CalcType(String type) {
        this.calcType = type;
    }
}
