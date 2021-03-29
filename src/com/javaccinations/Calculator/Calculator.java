package com.javaccinations.Calculator;

public interface Calculator {
    CalcType type = null;
    LoanTerm term = null;

    void display();

    double calculate();
}
