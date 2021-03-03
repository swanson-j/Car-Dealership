package com.ui;

import com.utility.FindUserType;

import java.util.Scanner;

public class LoginMenu extends AbstractMenu{
    FindUserType findUserTypeUtility = new FindUserType();

    @Override
    public void showMenu(Scanner scan) {
        for(int i = 0; i < 2; i++){
            System.out.println("Enter username: ");
            String username = scan.nextLine();
            System.out.println("Enter password:");
            String password = scan.nextLine();

            //TODO: Check database to see if username and password exist
            //  if they do, check for UserType and redirect to appropriate screen
            if(findUserTypeUtility.isEmployee(username, password)){
                EmployeeMenu employeeMenu = new EmployeeMenu();
            } else if(findUserTypeUtility.isCustomer(username, password)){
                CustomerMenu customerMenu = new CustomerMenu();
            } else if(findUserTypeUtility.isUser(username,password)){
                UserMenu userMenu = new UserMenu();
            } else if(findUserTypeUtility.isNotUser(username, password)){
                System.out.println("Username or password incorrect. Try again.");
            } else {
                System.out.println("Username or password incorrect. Try again.");
            }
        }
    }
}
