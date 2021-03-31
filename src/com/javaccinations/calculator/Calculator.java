package com.javaccinations.calculator;

public interface Calculator {
    CalcType type = null;
    LoanTerm term = null;

    void display(Mortgage mortgage);

    double calculate(Mortgage mortgage);
}
