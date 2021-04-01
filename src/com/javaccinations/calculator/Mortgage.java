package com.javaccinations.calculator;

public class Mortgage {
    private double homePrice;
    private double downPayment;
    private double principal;
    private double rate, newRate;
    private int loanTerm, newLoanTerm, originationYear;

    //CONSTRUCTORS
    public Mortgage(){};

    public Mortgage(double homePrice, double downPayment,int loanTerm, double rate) {
        setHomePrice(homePrice);
        setDownPayment(downPayment);
        setLoanTerm(loanTerm);
        setRate(rate);

    }

    public Mortgage(double principal, int loanTerm, double rate, int newLoanTerm, double newRate, int originationYear) {
        setPrincipal(principal);
        setLoanTerm(loanTerm);
        setRate(rate);
        setNewLoanTerm(newLoanTerm);
        setNewRate(newRate);
        setOriginationYear(originationYear);
    }

    //ACCESSOR METHODS
    public double getHomePrice() {
        return homePrice;
    }

    public void setHomePrice(double homePrice) {
        this.homePrice = homePrice;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getNewRate() {
        return newRate;
    }

    public void setNewRate(double newRate) {
        this.newRate = newRate;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public int getNewLoanTerm() {
        return newLoanTerm;
    }

    public void setNewLoanTerm(int newLoanTerm) {
        this.newLoanTerm = newLoanTerm;
    }

    public int getOriginationYear() {
        return originationYear;
    }

    public void setOriginationYear(int originationYear) {
        this.originationYear = originationYear;
    }
}