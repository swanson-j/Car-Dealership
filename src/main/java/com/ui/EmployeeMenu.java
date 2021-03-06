package com.ui;

import com.service.CustomerService;
import com.service.EmployeePaymentViewService;
import com.service.EmployeeService;
import com.service.RemoveCarService;

import java.util.Scanner;

public class EmployeeMenu extends AbstractMenu {

    @Override
    public void showMenu(Scanner scan) {
        System.out.println("=========================EmployeeMenu=========================");

        EmployeeService employeeService = new EmployeeService();
        boolean continueLoop = true;

        while(continueLoop){
            System.out.println("Add car, Review offer, Remove car, View payments, Exit");
            String response = scan.nextLine();

            if(response.equals("Add car")){
                AddCarMenu addCarMenu = new AddCarMenu();
                addCarMenu.showMenu(scan);
            }else if(response.equals("Review offer")){
                ReviewOfferMenu reviewOfferMenu = new ReviewOfferMenu();
                reviewOfferMenu.showMenu(scan);
            }else if(response.equals("Remove car")){
                RemoveCarMenu removeCarMenu = new RemoveCarMenu();
                removeCarMenu.showMenu(scan);
            }else if(response.equals("View payments")){
                EmployeePaymentViewMenu employeePaymentViewMenu = new EmployeePaymentViewMenu();
                employeePaymentViewMenu.showMenu(scan);
            }else if(response.equals("Exit")){
                continueLoop = false;
            }
        }
    }
}
