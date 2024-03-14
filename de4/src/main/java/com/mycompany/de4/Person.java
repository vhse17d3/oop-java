/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de4;

/**
 *
 * @author sonki
 */
public class Person {

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysnh() {
        return ngaysnh;
    }

    public void setNgaysnh(String ngaysnh) {
        this.ngaysnh = ngaysnh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Person() {
    }

    public Person(String hoten, String ngaysnh, String diachi, String gioitinh) {
        this.hoten = hoten;
        this.ngaysnh = ngaysnh;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
    }

    @Override
    public String toString() {
        return "hoten=" + hoten + ", ngaysnh=" + ngaysnh + ", diachi=" + diachi + ", gioitinh=" + gioitinh ;
    }
    private String hoten;
    private String ngaysnh;
    private String diachi; 
    private String gioitinh ;
    
}
