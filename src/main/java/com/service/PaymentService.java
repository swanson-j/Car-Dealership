package com.service;

import com.dao.CustomerDao;
import com.dao.EmployeeDao;
import com.model.Offer;
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

    public int createPayment(Offer offer, Scanner scan){
        float carPrice = 0f;
        float downPayment = 0f;
        float loanAmount = 0f;
        float interestRate = 0f;
        int months = 0;

        System.out.println("Car price: ");
        while(scan.hasNext()){
            if(scan.hasNextFloat()){
                carPrice = scan.nextFloat();
                break;
            } else {
                System.out.println("Car price: ");
            }
        }

        System.out.println("Down payment: ");
        while(scan.hasNext()){
            if(scan.hasNextFloat()){
                downPayment = scan.nextFloat();
                break;
            } else {
                System.out.println("Down payment: ");
            }
        }

        loanAmount = carPrice - downPayment;

        System.out.println("Interest rate: ");
        while(scan.hasNext()){
            if(scan.hasNextFloat()){
                interestRate = scan.nextFloat();
                break;
            } else {
                System.out.println("Interest rate: ");
            }
        }

        System.out.println("Loan term(months): ");
        while(scan.hasNext()){
            if(scan.hasNextInt()){
                months = scan.nextInt();
                break;
            } else {
                System.out.println("Loan term(months): ");
            }
        }

        Payment payment = new Payment(carPrice, downPayment, loanAmount, interestRate, months);
        payment.setMonthlyPayment(calculateMonthlyPayment(payment));
        EmployeeDao employeeDao = new EmployeeDao();

        int count = 0;
        for(int i = 0; i < months; i++){
            String paymentId = offer.getVinNumber().concat(offer.getUsername()).concat(String.valueOf(i));
            count = count + employeeDao.createPayments(paymentId, offer.getUsername(), offer.getVinNumber(), payment.getMonthlyPayment());
        }

        return count;
    }
}
