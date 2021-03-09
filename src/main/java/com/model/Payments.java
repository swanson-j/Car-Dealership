package com.model;

public class Payments {
    private float carPrice;
    private float downPayment;
    private float loanAmount;
    private float interestRate;
    private int months;
    private float monthlyPayment;

    public Payments(float carPrice, float downPayment, float loanAmount, float interestRate, int months) {
        this.carPrice = carPrice;
        this.downPayment = downPayment;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.months = months;
    }

    public float getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(float carPrice) {
        this.carPrice = carPrice;
    }

    public float getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(float downPayment) {
        this.downPayment = downPayment;
    }

    public float getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(float loanAmount) {
        this.loanAmount = loanAmount;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public float getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(float monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}
