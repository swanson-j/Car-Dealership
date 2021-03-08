package com.ui;

import com.model.Offer;
import com.model.User;
import com.service.CustomerService;

import java.util.Scanner;

public class OfferMenu extends AbstractMenu{
    private Offer offer;
    private User user;

    public OfferMenu(User user) {
        this.user = user;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void showMenu(Scanner scan) {
        System.out.println("============OfferMenu============");
        CustomerService customerService = new CustomerService();
        boolean continueLoop = true;

        while(continueLoop){
            System.out.println("Enter vin number: ");
            String vinNumber = scan.next();
            System.out.println("Enter offer amount:");
            float offerPrice = 0;
            while(scan.hasNext()){
                if(scan.hasNextFloat()){
                    offerPrice = scan.nextFloat();
                    break;
                } else {
                    System.out.println("Enter offer amount:");
                    scan.next();
                }
            }

            if(customerService.carExistsByVin(vinNumber)){
                String offerId = vinNumber.concat(user.getUsername());
                if(customerService.offerExists(offerId)){
                    System.out.println("You have already placed an offer on this car. Old offer will be overridden.");
                    System.out.println("Number of updated rows: " + customerService.remakeOffer(offerId, offerPrice));
                    return;
                } else {
                    // TODO: Save offer to database.
                    Offer offer = new Offer(offerPrice, vinNumber, user.getUsername());
                    System.out.println("You made a new offer!!");
                    System.out.println("Number of updated rows: " + customerService.makeNewOffer(offer));
                    return;
                }
            } else {
                System.out.println("Car does not exist in lot.");
            }
        }
    }
}
