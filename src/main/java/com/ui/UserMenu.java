package com.ui;

import com.dao.UserDao;
import com.model.User;
import com.model.UserType;
import com.service.UserService;
import com.utility.UIUtility;

import java.util.Scanner;

public class UserMenu extends AbstractMenu{
    private User user;
    String userMessage = "Register as customer? y or n";

    public UserMenu(User user){
        setUser(user);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void showMenu(Scanner scan) {
        System.out.println("============UserMenu============");

        UIUtility uiUtility = new UIUtility(userMessage);
        if(uiUtility.yOrN(scan) == true){
            getUser().setUserType(UserType.CUSTOMER);
            //TODO: set user type to Customer in database and pull up Customer Menu
            UserService userService = new UserService();
            if(userService.updateToCustomer(getUser())){
                System.out.println("Registered as Customer!");
                CustomerMenu customerMenu = new CustomerMenu();
                customerMenu.showMenu(scan);
            } else {
                System.out.println("Cannot register as customer");
            }

            return;
        } else {
            System.out.println("Goodbye!!");
            return;
        }
    }

}
