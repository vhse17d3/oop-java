/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de3;

/**
 *
 * @author sonki
 */
public class NhanVien extends Person{

    public String getPhongban() {
        return phongban;
    }

    public void setPhongban(String phongban) {
        this.phongban = phongban;
    }

    public int getHesoluong() {
        return hesoluong;
    }

    public void setHesoluong(int hesoluong) {
        this.hesoluong = hesoluong;
    }

    public int getThamnien() {
        return thamnien;
    }

    public void setThamnien(int thamnien) {
        this.thamnien = thamnien;
    }

    public float getLuongcoban() {
        return luongcoban;
    }

    public void setLuongcoban(float luongcoban) {
        this.luongcoban = luongcoban;
    }

    @Override
    public String toString() {
        return super.toString()+ ", phongban=" + phongban + ", hesoluong=" + hesoluong + ", thamnien=" + thamnien + ", luongcoban=" + luongcoban +tinhLuongThucLinh();
    }

    public NhanVien(String phongban, int hesoluong, int thamnien, float luongcoban, String hoten, String ngaysinh, String diachi, String gioitinh) {
        super(hoten, ngaysinh, diachi, gioitinh);
        this.phongban = phongban;
        this.hesoluong = hesoluong;
        this.thamnien = thamnien;
        this.luongcoban = luongcoban;
    }

    public NhanVien(String phongban, int hesoluong, int thamnien, float luongcoban) {
        this.phongban = phongban;
        this.hesoluong = hesoluong;
        this.thamnien = thamnien;
        this.luongcoban = luongcoban;
    }
    private String phongban;
    private int hesoluong ;
    private int thamnien; 
    private float luongcoban;
    public float tinhLuongThucLinh() {
        return luongcoban * hesoluong * (1 + thamnien / 100.0f); 
    }
}
