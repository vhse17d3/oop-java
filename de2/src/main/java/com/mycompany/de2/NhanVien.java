/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de2;

/**
 *
 * @author sonki
 */
public class NhanVien extends Person {

    public String getPhongban() {
        return phongban;
    }

    public void setPhongban(String phongban) {
        this.phongban = phongban;
    }

    public int getHeso() {
        return heso;
    }

    public void setHeso(int heso) {
        this.heso = heso;
    }

    public int getKinhnghiem() {
        return kinhnghiem;
    }

    public void setKinhnghiem(int kinhnghiem) {
        this.kinhnghiem = kinhnghiem;
    }

    public float getLuongcoban() {
        return luongcoban;
    }

    public void setLuongcoban(float luongcoban) {
        this.luongcoban = luongcoban;
    }

    public NhanVien() {
    }

    public NhanVien(String phongban, int heso, int kinhnghiem, float luongcoban, String hoten, String ngaysinh, String diachi, String gioitinh) {
        super(hoten, ngaysinh, diachi, gioitinh);
        this.phongban = phongban;
        this.heso = heso;
        this.kinhnghiem = kinhnghiem;
        this.luongcoban = luongcoban;
    }

    @Override
    public String toString() {
        return super.toString()+ ", phongban=" + phongban + ", heso=" + heso + ", kinhnghiem=" + kinhnghiem + ", luongcoban=" + luongcoban + ", luongthuc" + luongthuc() ;
    }
    private String phongban;
    private int heso; 
    private int kinhnghiem ; 
    private float luongcoban; 
    public float luongthuc(){
        return luongcoban *heso*(1+kinhnghiem/100.0f);
    }
}
