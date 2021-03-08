package com.ui;

import com.model.User;
import com.model.UserType;
import com.service.LoginService;
import com.utility.FindUserType;

import java.util.Scanner;

public class LoginMenu extends AbstractMenu{

    private User user;
    LoginService loginService = new LoginService();
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

            User user = loginService.getUserByCredentials(username, password);

            if(!(user == null)){
                //TODO: check for UserType and redirect to appropriate screen
                if(user.getUserType() == UserType.EMPLOYEE){
                    EmployeeMenu employeeMenu = new EmployeeMenu();
                    employeeMenu.showMenu(scan);
                } else if(user.getUserType() == UserType.CUSTOMER){
                    CustomerMenu customerMenu = new CustomerMenu(user);
                    customerMenu.showMenu(scan);
                } else if(user.getUserType() == UserType.USER){
                    UserMenu userMenu = new UserMenu(user);
                    userMenu.showMenu(scan);
                }
                return;
            } else {
                System.out.println("Username or password incorrect. " + (1-i) + " attempts remaining");
            }
        }
    }
}
