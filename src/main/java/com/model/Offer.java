package com.model;

public class Offer {
    private float offerPrice;
    private String vinNumber;
    private String username;

    public float getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(float offerPrice) {
        this.offerPrice = offerPrice;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Offer(float offerPrice, String vinNumber, String username) {
        this.offerPrice = offerPrice;
        this.vinNumber = vinNumber;
        this.username = username;
    }

    public Offer() {    }
}
