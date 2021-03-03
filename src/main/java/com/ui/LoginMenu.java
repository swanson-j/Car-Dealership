package com.ui;

import java.util.Scanner;

public class LoginMenu extends AbstractMenu{

    @Override
    public void showMenu(Scanner scan) {
        for(int i = 0; i < 2; i++){
            System.out.println("Enter username: ");
            String username = scan.nextLine();
            System.out.println("Enter password:");
            String password = scan.nextLine();

            //TODO: Check database to see if username and password exist
            //  if they do, check for UserType and redirect to appropriate screen
            
        }
    }
}
