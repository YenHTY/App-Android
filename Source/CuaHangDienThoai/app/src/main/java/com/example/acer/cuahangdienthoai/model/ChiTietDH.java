package com.example.acer.cuahangdienthoai.model;

public class ChiTietDH {

    public String tensp;
    public  String giasp;
    public  String hinhsp;
    public  String soluongsp;

    public ChiTietDH(String tensp, String giasp, String hinhsp, String soluongsp) {
        this.tensp = tensp;
        this.giasp = giasp;
        this.hinhsp = hinhsp;
        this.soluongsp = soluongsp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getGiasp() {
        return giasp;
    }

    public void setGiasp(String giasp) {
        this.giasp = giasp;
    }

    public String getHinhsp() {
        return hinhsp;
    }

    public void setHinhsp(String hinhsp) {
        this.hinhsp = hinhsp;
    }

    public String getSoluongsp() {
        return soluongsp;
    }

    public void setSoluongsp(String soluongsp) {
        this.soluongsp = soluongsp;
    }
}
