/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carsproject.Object;

/**
 *
 * @author sonki
 */
public class Customer {   
    private String CUSID;
    private String HoTen;
    private String DiaChi;
    private String SoDienThoai;
    private String Email;

    // Constructors
    public Customer() {
    }

    public Customer (String CUSID, String HoTen, String DiaChi, String SoDienThoai, String Email) {
        this.CUSID = CUSID;
        this.HoTen = HoTen;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
    }

    // Getter and Setter methods
    public String getCUSID() {
        return CUSID;
    }

    public void setCUSID(String CUSID) {
        this.CUSID = CUSID;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
      public boolean isValid() {
        return CUSID != null && HoTen != null && DiaChi != null && SoDienThoai != null && Email != null;
    }
}
