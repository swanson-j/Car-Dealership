package com.ui;

import java.util.Scanner;

public class UserMenu extends AbstractMenu{

    @Override
    public void showMenu(Scanner scan) {
        System.out.println("Register as customer? y or n");
    }
}
