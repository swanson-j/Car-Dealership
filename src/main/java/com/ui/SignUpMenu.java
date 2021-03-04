package com.ui;

import com.model.User;

import java.util.Scanner;

public class SignUpMenu extends AbstractMenu{
    private User user;

    @Override
    public void showMenu(Scanner scan) {
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
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
