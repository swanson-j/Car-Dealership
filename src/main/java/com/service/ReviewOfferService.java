package com.service;

import com.dao.EmployeeDao;
import com.model.Offer;

public class ReviewOfferService {
    static EmployeeDao employeeDao = new EmployeeDao();

    public boolean offerExists(String offerId){
        return employeeDao.offerExists(offerId);
    }

    public void getOfferDetails(Offer offer, String offerId){
        employeeDao.getOfferDetails(offer, offerId);
    }

    public int deleteOffersOnCar(String vinNumber){
        return employeeDao.deleteOffersOnCar(vinNumber);
    }

    public void changeCarOwnership(String username, String vinNumber, float offerPrice){
        employeeDao.changeCarOwnership(username, vinNumber, offerPrice);
    }

    public int deleteRejectedOffer(String offerId){
        return employeeDao.deleteRejectedOffer(offerId);
    }

}
