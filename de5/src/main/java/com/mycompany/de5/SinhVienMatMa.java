/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de5;

/**
 *
 * @author sonki
 */
public class SinhVienMatMa extends SinhVien{

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return super.toString()+ ", donvi=" + donvi + ", luong=" + luong ;
    }
    public SinhVienMatMa(){  
    }
    public SinhVienMatMa(String donvi, float luong, String masinhvien, String hoten, String ngaysinnh, String gioitinh, float diemtrungbinh) {
        super(masinhvien, hoten, ngaysinnh, gioitinh, diemtrungbinh);
        this.donvi = donvi;
        this.luong = luong;
    }

    private String donvi;
    private float luong;
    
}
