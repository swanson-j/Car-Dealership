package com.ui;

import com.model.User;
import com.utility.FindUserType;

import java.util.Scanner;

public class LoginMenu extends AbstractMenu{

    private User user;
    FindUserType findUserTypeUtility = new FindUserType();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void showMenu(Scanner scan) {
        System.out.println("============LoginMenu============");
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
                UserMenu userMenu = new UserMenu(getUser());
            } else if(findUserTypeUtility.isNotUser(username, password)){
                System.out.println("Username or password incorrect. Try again.");
            } else {
                System.out.println("Username or password incorrect. Try again.");
            }
        }
    }
}
