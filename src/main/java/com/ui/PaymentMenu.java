package com.ui;

import com.model.Payment;
import com.model.User;
import com.service.PaymentService;

import java.util.Scanner;

public class PaymentMenu extends AbstractMenu{
    private User user;

    public PaymentMenu(User user){
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void showMenu(Scanner scan) {
        System.out.println("=========================PaymentMenu=========================");
        System.out.println("Payment ID\t\t\t\t\tUsername\tVin Number\t\t\tPayment Type\tPayment Amount" );

        PaymentService paymentService = new PaymentService();
        paymentService.viewRemainingPayments(user.getUsername(), scan);
    }
}
