package com.service;

import com.dao.EmployeeDao;

public class RemoveCarService {
    public boolean carExistsOnLot(String vinNumber){
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.carExistsOnLot(vinNumber);
    }

    public int removeCarFromLot(String vinNumber){
        EmployeeDao employeeDao = new EmployeeDao();
        int count = 0;
        count += employeeDao.removeAllCarOffers(vinNumber);
        count += employeeDao.removeCarFromLot(vinNumber);
        return count;
    }
}
