package com.javaccinations.calculator;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*

public class RefinanceCalculatorTest  {
    private Calculator calc;
    //public Mortgage(double principal, int loanTerm, double rate, int newLoanTerm, double newRate, int originationYear)

    public void setUp() {
        calc = CalcFactory.createCalculator("Refinance");
    }
    @Test
    public void testDisplay() {
    }

    @Test
    public void testSetNewMortgage() {
    }

    @Test
    public void testCalculate() {
    }

    @Test
    public void testCalculateTotalInterests() {
        Mortgage mortgage = new Mortgage(400000.00,30,4,15,3,2015);
        ((RefinanceCalculator) calc).calculateTotalInterests(mortgage);
        assertEquals.

    }

    @Test
    public void testSummarizeResults() {
    }
}