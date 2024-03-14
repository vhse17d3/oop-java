/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carsproject.Object;

/**
 *
 * @author sonki
 */
public class Car {
    private String carID;
    private String brand;
    private String model;
    private boolean carStatus;
    private String licensePlate;
    private float price;

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public float getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(float totalBill) {
        this.totalBill = totalBill;
    }

    public float getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(float totalPayment) {
        this.totalPayment = totalPayment;
    }
    private int totalTime;
    private float totalBill;
    private float totalPayment;
    // Constructors
    public Car() {
        // Default constructor
    }

    public Car(String carID, String brand, String model, boolean carStatus, String licensePlate, float price) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.carStatus = carStatus;
        this.licensePlate = licensePlate;
        this.price = price;
    }
    public Car(String carID, String brand, String model, String licensePlate, float price, int totalTime, float totalBill, float totalPayment) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.price = price;
        this.totalTime = totalTime;
        this.totalBill = totalBill;
        this.totalPayment = totalPayment;
    }

    // Getters and Setters
    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isCarStatus() {
        return carStatus;
    }

    public void setCarStatus(boolean carStatus) {
        this.carStatus = carStatus;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
