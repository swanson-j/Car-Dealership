package com.ui;

import com.model.User;
import com.model.UserType;
import com.service.NonUserService;

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
            String password = scan.nextLine();

            //check username

            // if one does not exist
            User user = new User(userName, password, UserType.USER);
            NonUserService service = new NonUserService();
            service.saveUser(user);

        }
    }
}
