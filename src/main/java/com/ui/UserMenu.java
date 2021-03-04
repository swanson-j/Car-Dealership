package com.ui;

import com.model.User;
import com.model.UserType;

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
        System.out.println(userMessage);
        UIUtility uiUtility = new UIUtility(userMessage);
        if(uiUtility.yOrN(scan) == true){
            user.setUserType(UserType.CUSTOMER);
            //TODO: set user type to Customer in database and pull up Customer Menu
        } else {
            System.out.println("Goodbye!!");
            return;
        }
    }

}
