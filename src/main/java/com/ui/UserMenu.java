package com.ui;

import com.model.User;

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

            //TODO: check if username and password exist
            //      if not then create new user in database
            //      and send this user to customer menu
            while(true){
                System.out.println("Username: ");
                getUser().setUsername(scan.nextLine());
                System.out.println("Password: ");
                getUser().setPassword(scan.nextLine());

                //check username
            }
        } else {
            System.out.println("Goodbye!!");
            return;
        }
    }

}
