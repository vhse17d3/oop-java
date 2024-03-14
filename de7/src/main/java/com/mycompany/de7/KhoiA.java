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
public class KhoiA extends ThiSinh {

    public float getToan() {
        return toan;
    }

    public void setToan(float toan) {
        this.toan = toan;
    }

    public float getLy() {
        return ly;
    }

    public void setLy(float ly) {
        this.ly = ly;
    }

    public float getHoa() {
        return hoa;
    }

    public void setHoa(float hoa) {
        this.hoa = hoa;
    }

    @Override
    public String toString() {
        return super.toString()+ ", toan=" + toan + ", ly=" + ly + ", hoa=" + hoa ;
    }

    public KhoiA(float toan, float ly, float hoa, String hoten, String ngaysinh, String diachi) {
        super(hoten, ngaysinh, diachi);
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }

    public KhoiA() {
    }
    public KhoiA nhapthongtin (){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập họ tên: ");
        String hoten = input.nextLine();
        System.out.print("Nhập ngày sinh: ");
        String ngaysinh = input.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String diachi = input.nextLine();
        System.out.println("nhập điểm toán");
        float toan= Float.parseFloat(input.nextLine());
        System.out.println("nhập điểm lý");
        float ly= Float.parseFloat(input.nextLine());
        System.out.println("nhập hóa");
        float hoa= Float.parseFloat(input.nextLine());
        return  new KhoiA(toan,ly,hoa,hoten,ngaysinh,diachi);
        
    }
    private float toan;
    private float ly; 
    private float hoa;
    public float tongdiem(){
        return toan+ly+hoa;
    }
}
