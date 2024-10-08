package edu.huflit.appphongtro.HoaDon;

import java.io.Serializable;

public class HoaDon implements Serializable {
    private int idHoadon;
    private int idPhong;
    private String TenKhach;
    private int dien;
    private int nuoc;
    private int tienPhong;
    private int tongTien;

    public HoaDon(int idHoadon, int idPhong, String tenKhach, int dien, int nuoc, int tienPhong, int tongTien) {
        this.idHoadon = idHoadon;
        this.idPhong = idPhong;
        TenKhach = tenKhach;
        this.dien = dien;
        this.nuoc = nuoc;
        this.tienPhong = tienPhong;
        this.tongTien = tongTien;
    }

    public int getIdHoadon() {
        return idHoadon;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public String getTenKhach() {
        return TenKhach;
    }

    public int getDien() {
        return dien;
    }

    public int getNuoc() {
        return nuoc;
    }

    public int getTienPhong() {
        return tienPhong;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setIdHoadon(int idHoadon) {
        this.idHoadon = idHoadon;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public void setTenKhach(String tenKhach) {
        TenKhach = tenKhach;
    }

    public void setDien(int dien) {
        this.dien = dien;
    }

    public void setNuoc(int nuoc) {
        this.nuoc = nuoc;
    }

    public void setTienPhong(int tienPhong) {
        this.tienPhong = tienPhong;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
}
