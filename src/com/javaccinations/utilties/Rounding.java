package com.javaccinations.utilties;

public class Rounding {
    public static double roundMe2Decimals(double number){
        return Math.round(number*100.0)/100.0;
    }
}