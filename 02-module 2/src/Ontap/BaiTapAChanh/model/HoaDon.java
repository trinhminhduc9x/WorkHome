package Ontap.BaiTapAChanh.model;

import java.time.LocalDate;

public class HoaDon {
   private int stt;
   private String maHoaDon;
   private String maKhachHang;
   private LocalDate ngayRa ;
   private int soLuong;
   private int donGia;
   private int thanhtien;

    public HoaDon() {
    }

    public HoaDon(int stt, String maHoaDon, String maKhachHang, LocalDate ngayRa, int soLuong, int donGia, int thanhtien) {
        this.stt = stt;
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.ngayRa = ngayRa;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhtien = thanhtien;
    }
    public String getInfoToCSV() {
        return this.stt + "," + this.maHoaDon + "," + this.maKhachHang + "," + this.ngayRa+ "," + this.soLuong+ "," + this.donGia+ "," + this.thanhtien;
    }
    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public LocalDate getNgayRa() {
        return ngayRa;
    }

    public void setNgayRa(LocalDate ngayRa) {
        this.ngayRa = ngayRa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "stt=" + stt +
                ", maHoaDon='" + maHoaDon + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", ngayRa=" + ngayRa +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", thanhtien=" + thanhtien +
                '}';
    }
}
