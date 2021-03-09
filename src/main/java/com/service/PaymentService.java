package com.service;

import com.model.Payment;

public class PaymentService {

    public float calculateMonthlyPayment(Payment payment){
        float monthlyInterestRate = payment.getInterestRate()/100/12;
        float interest = monthlyInterestRate * payment.getLoanAmount();
        monthlyInterestRate = monthlyInterestRate + 1;
        float monthlyPayment = (float)Math.pow(monthlyInterestRate,payment.getMonths());
        monthlyPayment = 1 / monthlyPayment;
        monthlyPayment = 1 - monthlyPayment;
        monthlyPayment = interest / monthlyPayment;
        return (float) (Math.round(monthlyPayment * 100.0) / 100.0);
    }

    public float calculateLoanAmount(float carPrice, float downPayment){
        return carPrice-downPayment;
    }
}
