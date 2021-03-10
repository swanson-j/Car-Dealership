package com.service;

import com.dao.EmployeeDao;
import com.model.DbPayment;

import java.util.Scanner;

public class EmployeePaymentViewService {
    final int PAGECOUNT = 20;
    public void viewAllPayments(Scanner scan){
        EmployeeDao employeeDao = new EmployeeDao();
        int paymentCount = employeeDao.paymentCount();
        int pages = (paymentCount / PAGECOUNT) + 1;

        for(int i = 0; i < pages; i++){
            int offset = i * PAGECOUNT;
            employeeDao.viewAllPayments(offset, PAGECOUNT);
            boolean continueLoop = true;
            while(continueLoop){
                System.out.println("Next");
                String response = scan.nextLine();
                if(response.equals("Next")){
                    continueLoop = false;
                }
            }

        }
    }

}
