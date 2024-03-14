/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de5;

/**
 *
 * @author sonki
 */
public class SinhVien {

    public String getMasinhvien() {
        return masinhvien;
    }

    public void setMasinhvien(String masinhvien) {
        this.masinhvien = masinhvien;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public float getDiemtrungbinh() {
        return diemtrungbinh;
    }

    public void setDiemtrungbinh(float diemtrungbinh) {
        this.diemtrungbinh = diemtrungbinh;
    }
    public SinhVien(){
        
    }
    @Override
    public String toString() {
        return  "masinhvien=" + masinhvien + ", hoten=" + hoten + ", ngaysinnh=" + ngaysinnh + ", gioitinh=" + gioitinh + ", diemtrungbinh=" + diemtrungbinh  ;
    }

    public String getNgaysinnh() {
        return ngaysinnh;
    }

    public void setNgaysinnh(String ngaysinnh) {
        this.ngaysinnh = ngaysinnh;
    }

    public SinhVien(String masinhvien, String hoten, String ngaysinnh, String gioitinh, float diemtrungbinh) {
        this.masinhvien = masinhvien;
        this.hoten = hoten;
        this.ngaysinnh = ngaysinnh;
        this.gioitinh = gioitinh;
        this.diemtrungbinh = diemtrungbinh;
    }

   
  
    private String masinhvien;
    private String hoten;
    private String ngaysinnh;
    private String gioitinh;
    private float diemtrungbinh;
}
