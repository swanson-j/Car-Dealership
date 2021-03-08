package com.ui;

import com.model.User;
import com.service.CustomerService;

import java.util.Scanner;

public class CustomerMenu extends AbstractMenu{
    private User user;

    public CustomerMenu(User user){
        this.user = user;
    }

    public void showMenu(Scanner scan) {
        System.out.println("=========================CustomerMenu=========================");

        CustomerService customerService = new CustomerService();
        boolean continueLoop = true;

        while(continueLoop){
            System.out.println("View lot, Make offer, View owned cars, View payments, Exit");
            String response = scan.nextLine();

            if(response.equals("View lot")){
                customerService.showLot(scan);
            }else if(response.equals("Make offer")){
                // TODO: check if vin and user exist in database
                //          if it does, override the offer value
                //          else create an id and put it in the database
                OfferMenu offerMenu = new OfferMenu(user);
                offerMenu.showMenu(scan);
            }else if(response.equals("View owned cars")){
            }else if(response.equals("View payments")){
            }else if(response.equals("Exit")){
                continueLoop = false;
            }
        }
    }
}
