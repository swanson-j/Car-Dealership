package com.service;

import com.dao.CustomerDao;
import com.model.Payment;

import java.util.Scanner;

public class PaymentService {

    final int COUNT = 20;

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

    public void viewRemainingPayments(String username, Scanner scan){
        CustomerDao customerDao = new CustomerDao();
        int remainingPaymentCount = customerDao.remainingPaymentCount(username);
        int pages = remainingPaymentCount / COUNT;

        for(int i = 0; i < pages+1 ; i++){
            boolean continueLoop = true;
            customerDao.viewRemainingPayments(username,i*COUNT);
            while(continueLoop){
                System.out.println("Type 'Next' to continue");
                if(scan.nextLine().equals("Next")){
                    continueLoop = false;
                }
            }
        }
    }
}
