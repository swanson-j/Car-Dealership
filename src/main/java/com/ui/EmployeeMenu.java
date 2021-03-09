package com.ui;

import com.service.CustomerService;
import com.service.EmployeeService;

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
            }else if(response.equals("Remove car")){
            }else if(response.equals("View payments")){
            }else if(response.equals("Exit")){
                continueLoop = false;
            }
        }
    }
}
