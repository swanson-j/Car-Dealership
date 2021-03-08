package com.model;

public class Car {
    private String vinNumber;
    private String make;
    private String model;
    private int year;
    private float value;
    private CarType carType;
    private String username;

    public Car(String vinNumber, String make, String model, int year, float value, CarType carType) {
        this.vinNumber = vinNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.value = value;
        this.carType = carType;
    }

    public Car(String vinNumber, String make, String model, int year, float value, CarType carType, String username) {
        this.vinNumber = vinNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.value = value;
        this.carType = carType;
        this.username = username;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
