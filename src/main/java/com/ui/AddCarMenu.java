package com.ui;

import com.dao.EmployeeDao;
import com.model.Car;
import com.model.CarType;
import com.service.EmployeeService;

import java.util.Scanner;

public class AddCarMenu extends AbstractMenu{
    public void showMenu(Scanner scan) {
        System.out.println("Enter vin number: ");
        String vinNumber = scan.nextLine();
        System.out.println("Enter make: ");
        String make = scan.nextLine();
        System.out.println("Enter model: ");
        String model = scan.nextLine();
        System.out.println("Enter year: ");
        int year = 0;
        while(scan.hasNext()){
            if(scan.hasNextInt()){
                year = scan.nextInt();
                break;
            } else {
                System.out.println("Enter year:");
                scan.next();
            }
        }
        float value = 0f;
        System.out.println("Enter value: ");
        while(scan.hasNext()){
            if(scan.hasNextFloat()){
                value = scan.nextInt();
                break;
            } else {
                System.out.println("Enter value:");
                scan.next();
            }
        }

        Car car = new Car(vinNumber,make,model,year,value);
        EmployeeService employeeService = new EmployeeService();
        System.out.println("Number of updated rows: " + employeeService.addCarToLot(car));
    }
}
