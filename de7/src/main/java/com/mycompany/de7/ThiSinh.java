/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de7;

import java.util.Scanner;

/**
 *
 * @author sonki
 */
public class ThiSinh {

    public ThiSinh(String hoten, String ngaysinh, String diachi) {
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
    }

    public ThiSinh() {
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
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
    public ThiSinh nhapthongtin(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập họ tên: ");
        String hoten = input.nextLine();
        System.out.print("Nhập ngày sinh: ");
        String ngaysinh = input.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String diachi = input.nextLine();
        return new ThiSinh(hoten,ngaysinh,diachi);
    }
    @Override
    public String toString() {
        return "hoten=" + hoten + ", ngaysinh=" + ngaysinh + ", diachi=" + diachi ;
    }
  
    private String hoten;
    private String ngaysinh;
    private String diachi; 
    
}
