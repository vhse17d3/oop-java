/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de4;

/**
 *
 * @author sonki
 */
public class Student extends Person {

    public Student() {
    }

    public Student(String msv, String email, float gpa, String hoten, String ngaysnh, String diachi, String gioitinh) {
        super(hoten, ngaysnh, diachi, gioitinh);
        this.msv = msv;
        this.email = email;
        this.gpa = gpa;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() + "msv=" + msv + ", email=" + email + ", gpa=" + gpa ;
    }
    private String  msv ;
    private String email;
    private float gpa;
    
    
}
