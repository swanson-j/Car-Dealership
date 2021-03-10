package com.model;

public class DbPayment {
    private String paymentId;
    private String username;
    private String vinNumber;
    private PaymentType paymentType;
    private float paymentAmount;

    public DbPayment(String paymentId, String username, String vinNumber, PaymentType paymentType, float paymentAmount) {
        this.paymentId = paymentId;
        this.username = username;
        this.vinNumber = vinNumber;
        this.paymentType = paymentType;
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public float getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(float paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
