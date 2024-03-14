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
public class KhoiC extends ThiSinh {

    public KhoiC() {
    }

    public float getVan() {
        return van;
    }

    public void setVan(float van) {
        this.van = van;
    }

    public float getSu() {
        return su;
    }

    public void setSu(float su) {
        this.su = su;
    }

    public float getDia() {
        return dia;
    }

    public void setDia(float dia) {
        this.dia = dia;
    }

    public KhoiC(float van, float su, float dia, String hoten, String ngaysinh, String diachi) {
        super(hoten, ngaysinh, diachi);
        this.van = van;
        this.su = su;
        this.dia = dia;
    }

    @Override
    public String toString() {
        return super.toString()+ ", van=" + van + ", su=" + su + ", dia=" + dia;
    }
    private float van;
    private float su;
    private float dia;  
    public KhoiC nhapthongtin (){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập họ tên: ");
        String hoten = input.nextLine();
        System.out.print("Nhập ngày sinh: ");
        String ngaysinh = input.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String diachi = input.nextLine();
        System.out.println("nhập điểm văn");
        float van= Float.parseFloat(input.nextLine());
        System.out.println("nhập điểm sử");
        float su= Float.parseFloat(input.nextLine());
        System.out.println("nhập địa");
        float dia= Float.parseFloat(input.nextLine());
        return  new KhoiC(van,su,dia,hoten,ngaysinh,diachi);
        
    }
    public float tongdiem(){
        return van+su+dia; 
    }
}
