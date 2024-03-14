/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de1;

/**
 *
 * @author sonki
 */
public class Student extends Person {

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
        return super.toString()+", msv=" + msv + ", email=" + email + ", gpa=" + gpa ;
    }
    public Student( String name, String ngaysinh, String diachi,  String gioitinh, String msv,String email, float gpa) {
        super(name, ngaysinh, diachi, gioitinh);
        this.msv = msv;
        this.email = email;
        this.gpa = gpa;
    }
    private String msv ;
    private String email;
    private float gpa;
    public static void main(String[] args) {
        // Tạo một đối tượng sinh viên và hiển thị thông tin bằng toString()
        Student student = new Student("John Doe", "01/01/1990", "123 Main St", "Male", "123456", "john@example.com", (float) 3.5);
        System.out.println(student);
    }
}
