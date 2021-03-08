package com.service;

import com.dao.CustomerDao;
import com.model.Offer;
import com.ui.CustomerMenu;

import java.util.Scanner;

public class CustomerService {
    static CustomerDao customerDao = new CustomerDao();
    final int COUNT = 5;

    public void showLot(Scanner scan){
        CustomerDao customerDao = new CustomerDao();
        int lotCount = customerDao.lotCount();
        int pages = lotCount / COUNT;

        System.out.println("vin\t\t\t\t\tmake\t\tmodel\tyear\tprice");

        for(int i = 0; i < pages+1 ; i++){
            boolean continueLoop = true;
            customerDao.showLot(i*COUNT);
            while(continueLoop){
                System.out.println("Type 'Next' to continue");
                if(scan.nextLine().equals("Next")){
                    continueLoop = false;
                }
            }
        }
    }

    public boolean carExistsByVin(String vinNumber){
        return customerDao.carExistsByVin(vinNumber);
    }

    public boolean offerExists(String offerId){
        return customerDao.offerExists(offerId);
    }

    public int remakeOffer(String offerId, float offerPrice){
        return customerDao.remakeOffer(offerId, offerPrice);
    }

    public int makeNewOffer(Offer offer){
        return customerDao.makeNewOffer(offer);
    }

    public void viewOwnedCars(String username){
        System.out.println("vin\t\t\t\t\tmake\t\tmodel\tyear\tprice");
        customerDao.viewOwnedCars(username);
    }
}
