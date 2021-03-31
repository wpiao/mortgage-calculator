// package com.javaccinations.Calculator;
//
// import org.junit.Before;
// import org.junit.Test;
//
// import static org.junit.Assert.*;
//
// public class MortgageCalculatorTest {
//     private static Calculator MortgageCalc;
//
//     @Before
//     public void setUp() {
//         MortgageCalc = CalcFactory.createCalculator("1", "50000", "10000", "30", "5");
//     }
//
//     @Test
//     public void calculate() {
//         double monthlyPayment = MortgageCalc.calculate();
//         assertEquals(215.0, monthlyPayment, .001);
//     }
// }