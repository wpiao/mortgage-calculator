package com.javaccinations.calculator;

public enum LoanTerm {
    FIFTEEN_YEAR("15"),
    THIRTY_YEAR("30");

    String loanTerm;

    LoanTerm(String term) {
        loanTerm = term;
    }

    public String getLoanTerm() {
        return loanTerm;
    }
}


