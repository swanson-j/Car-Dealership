package com.ui;

import com.dao.UserDao;
import com.model.User;
import com.model.UserType;
import com.service.NonUserService;
import com.service.UserService;

import java.util.Scanner;

public class SignUpMenu extends AbstractMenu{

    @Override
    public void showMenu(Scanner scan) {

        UserService userService = new UserService();

        System.out.println("============SignUpMenu============");
        //TODO: check if username and password exist
        //      if not then create new user in database
        //      and send this user to customer menu
        while(true){
            System.out.println("Username: ");
            String userName = scan.nextLine();
            System.out.println("Password: ");
            String password = scan.nextLine();

            // if username doesn't exist, make new user
            if(!userService.userExists(userName)){
                User user = new User(userName, password, UserType.USER);
                NonUserService nonUserService = new NonUserService();
                nonUserService.saveAsUser(user);
                System.out.println("Congratulations! You have been promoted to User status");
                UserMenu userMenu = new UserMenu(user);
                userMenu.showMenu(scan);
                // TODO: go to user menu
                return;
            } else {
                System.out.println("Username already exists. Try again.");
            }
        }
    }
}
