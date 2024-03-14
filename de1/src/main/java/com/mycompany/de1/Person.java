/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de1;

/**
 *
 * @author sonki
 */
public class Person {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
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
    public Person(){
        
    }

    @Override
    public String toString() {
        return  "name=" + name + ", ngaysinh=" + ngaysinh + ", diachi=" + diachi + ", gioitinh=" + gioitinh ;
    }
    public Person(String name, String ngaysinh, String diachi, String gioitinh) {
        this.name = name;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
    }
  
    private String name;
    private String ngaysinh;
    private String diachi;
    private String gioitinh;
    
}
