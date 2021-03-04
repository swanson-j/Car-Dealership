package com.ui;

import com.model.User;

import java.util.Scanner;

public class SignUpMenu extends AbstractMenu{

    @Override
    public void showMenu(Scanner scan) {

        System.out.println("============SignUpMenu============");
        //TODO: check if username and password exist
        //      if not then create new user in database
        //      and send this user to customer menu
        while(true){
            System.out.println("Username: ");
            String userName = scan.nextLine();
            System.out.println("Password: ");
            String Password = scan.nextLine();

            //check username

        }
    }
}
