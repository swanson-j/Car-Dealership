package com.service;

import com.dao.CustomerDao;
import com.ui.CustomerMenu;

import java.util.Scanner;

public class CustomerService {

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
}
