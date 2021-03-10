package com.ui;

import com.service.EmployeePaymentViewService;

import java.util.Scanner;

public class EmployeePaymentViewMenu extends AbstractMenu{
    EmployeePaymentViewService employeePaymentViewService = new EmployeePaymentViewService();

    public void showMenu(Scanner scan) {
        System.out.println("=========================PaymentMenu=========================");
        System.out.println("Payment ID\t\t\t\t\tUsername\tVin Number\t\tPayment Type\tPayment Amount" );
        employeePaymentViewService.viewAllPayments(scan);
    }
}
