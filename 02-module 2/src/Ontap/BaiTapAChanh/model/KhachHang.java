package Ontap.BaiTapAChanh.model;

public class KhachHang {
    private int stt;
    private String maKhachhang;
    private String hoVaTen;

    public KhachHang(int stt, String maKhachhang, String hoVaTen) {
        this.stt = stt;
        this.maKhachhang = maKhachhang;
        this.hoVaTen = hoVaTen;
    }

    public KhachHang() {
    }


    public String getInfoToCSV() {
        return this.stt + "," + this.maKhachhang + "," + this.hoVaTen;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMaKhachhang() {
        return maKhachhang;
    }

    public void setMaKhachhang(String maKhachhang) {
        this.maKhachhang = maKhachhang;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    @Override
    public String toString() {
        return "maKhachhang='" + maKhachhang + '\'' +
                ", hoVaTen='" + hoVaTen + '\'' ;
    }
}
