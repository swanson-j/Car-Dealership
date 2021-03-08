package com.model;

public class Car {
    private String vinNumber;
    private String make;
    private String model;
    private int year;
    private String color;
    private float value;
    private CarType carType;

    public Car(String vinNumber, String make, String model, int year, String color, float value, CarType carType) {
        this.vinNumber = vinNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.value = value;
        this.carType = carType;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
