package com.ui;

import com.service.RemoveCarService;

import java.util.Scanner;

public class RemoveCarMenu extends AbstractMenu{
    public void showMenu(Scanner scan) {
        RemoveCarService removeCarService = new RemoveCarService();

        System.out.println("============RemoveCarMenu============");

        while(true){
            System.out.println("Enter vin number: ");
            String vinNumber = scan.nextLine();
            if(removeCarService.carExistsOnLot(vinNumber)){
                System.out.println("Updated rows: "+removeCarService.removeCarFromLot(vinNumber));
                return;
            } else {
                System.out.println("Car doesn't exist on lot");
                return;
            }
        }

    }
}
