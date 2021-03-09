package com.service;

import com.dao.EmployeeDao;

public class ReviewOfferService {

    public boolean offerExists(String offerId){
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.offerExists(offerId);
    }

}
