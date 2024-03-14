/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carsproject.Object;

import java.sql.Date;

/**
 *
 * @author sonki
 */
public class Car_on_rent {
     private String carID;
    private String customerID;
    private String rentID;
    private Date rentDate;
    private Date returnDate;
    private float Price;
    private float Phat;
    private Date trueReturnDate;
    private int delay;

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getDelay() {
        return delay;
    }

    public void setPhat(float Phat) {
        this.Phat = Phat;
    }

    public void setTrueReturnDate(Date trueReturnDate) {
        this.trueReturnDate = trueReturnDate;
    }

    public float getPhat() {
        return Phat;
    }

    public Date getTrueReturnDate() {
        return trueReturnDate;
    }

    public Car_on_rent(String carID, String customerID, String rentID, Date rentDate, Date returnDate) {
        this.carID = carID;
        this.customerID = customerID;
        this.rentID = rentID;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    
    public Car_on_rent(String carID, String customerID, String rentID, Date rentDate, Date returnDate, float Price) {
        this.carID = carID;
        this.customerID = customerID;
        this.rentID = rentID;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.Price = Price;
    }

    
    public Car_on_rent() {
    }

    

    // Add getters and setters as needed

    public String getCarID() {
        return carID;
    }
    

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getRentID() {
        return rentID;
    }

    public void setRentID(String rentID) {
        this.rentID = rentID;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }  

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }
    
}
