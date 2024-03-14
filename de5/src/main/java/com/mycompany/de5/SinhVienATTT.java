/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de5;

/**
 *
 * @author sonki
 */
public class SinhVienATTT extends SinhVien {

    public float getHocphi() {
        return hocphi;
    }

    public void setHocphi(float hocphi) {
        this.hocphi = hocphi;
    }

    public SinhVienATTT() {

    }
  

    @Override
    public String toString() {
        return super.toString() + ", hocphi=" + hocphi ;
    }
    public SinhVienATTT(float hocphi, String masinhvien, String hoten, String ngaysinnh, String gioitinh, float diemtrungbinh) {
        super(masinhvien, hoten, ngaysinnh, gioitinh, diemtrungbinh);
        this.hocphi = hocphi;
    }
    private float hocphi;

}
