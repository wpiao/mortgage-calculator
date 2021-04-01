package com.javaccinations.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MortgageCalculatorTest {
    private Calculator calc;

    @Before
    public void setUp() {
        calc = CalcFactory.createCalculator("Purchase");
    }

    @Test
    public void calculateTest1() {
        Mortgage mort = new Mortgage(500000.0, 100000.0, 15, 5.0);
        double monthlyPayment = calc.calculate(mort);
        assertEquals(3163.0, monthlyPayment, .001);
    }

    @Test
    public void calculateTest2() {
        Mortgage mort = new Mortgage(1234567.0, 12345.0, 30, 2.75);
        double monthlyPayment = calc.calculate(mort);
        assertEquals(4990.0, monthlyPayment, .001);
    }

    @Test
    public void calculateTest3() {
        Mortgage mort = new Mortgage(600000.0, 0.0, 30, 2.50);
        double monthlyPayment = calc.calculate(mort);
        assertEquals(2371.0, monthlyPayment, .001);
    }
}
