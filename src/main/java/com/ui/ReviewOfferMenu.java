package com.ui;

import com.model.Offer;
import com.service.ReviewOfferService;

import java.util.Scanner;

public class ReviewOfferMenu extends AbstractMenu{
    public void showMenu(Scanner scan) {
        System.out.println("============OfferMenu============");
        ReviewOfferService reviewOfferService = new ReviewOfferService();

        while(true){
            System.out.println("Enter offer id: ");
            String offerId = scan.nextLine();

            if(reviewOfferService.offerExists(offerId)){
                while(true){
                    System.out.println("Accept or Decline");
                    if(scan.nextLine().equals("Accept")){
                        // TODO: get the vin number of the vehicle and the user
                        //          delete all offers containing that vin number
                        //          change car in car table to OWNED by the user
                        //          calculate payments and add to db
                        Offer offer = new Offer();
                        ReviewOfferService reviewOfferService1 = new ReviewOfferService();
                        reviewOfferService.getOfferDetails(offer, offerId);
                        System.out.println("Vin number: " + offer.getVinNumber());
                        System.out.println("Username: " + offer.getUsername());
                        System.out.println("Offer price: " + offer.getOfferPrice());
                        System.out.println("Number of updated rows: " + reviewOfferService.deleteOffersOnCar(offer.getVinNumber()));

                        return;
                    } else if(scan.nextLine().equals("Decline")){
                        // TODO: remove offer from offer table
                    }
                }
            } else {
                System.out.println("Offer does not exist! Try again.");
            }

        }
    }
}