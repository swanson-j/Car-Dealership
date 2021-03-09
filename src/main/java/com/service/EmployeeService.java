package com.service;

import com.dao.EmployeeDao;
import com.model.Car;

public class EmployeeService {

    public int addCarToLot(Car car){
        EmployeeDao employeeDao = new EmployeeDao();
        if(employeeDao.carExists(car.getVinNumber())){
            System.out.println("Car already exists");
            return 0;
        }
        return employeeDao.addCarToLot(car);
    }
}
