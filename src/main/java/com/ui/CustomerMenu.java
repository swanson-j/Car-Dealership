package com.ui;

import com.model.Payment;
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
                OfferMenu offerMenu = new OfferMenu(user);
                offerMenu.showMenu(scan);
            }else if(response.equals("View owned cars")){
                customerService.viewOwnedCars(user.getUsername());
            }else if(response.equals("View payments")){
                PaymentMenu paymentMenu = new PaymentMenu(user);
                paymentMenu.showMenu(scan);
            }else if(response.equals("Exit")){
                continueLoop = false;
            }
        }
    }
}
