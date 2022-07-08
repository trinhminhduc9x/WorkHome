package Ontap.BaiTapAChanh.model;

public class KhachHangVietNam extends KhachHang{
    private String loaiKhachHang;
    private int dinhMucTieuThu;

    public KhachHangVietNam(int stt, String maKhachhang, String hoVaTen, String loaiKhachHang, int dinhMucTieuThu) {
        super(stt, maKhachhang, hoVaTen);
        this.loaiKhachHang = loaiKhachHang;
        this.dinhMucTieuThu = dinhMucTieuThu;
    }

    public KhachHangVietNam(String loaiKhachHang, int dinhMucTieuThu) {
        this.loaiKhachHang = loaiKhachHang;
        this.dinhMucTieuThu = dinhMucTieuThu;
    }

    public String getInfoToCSV() {
        return super.getInfoToCSV() + "," + this.loaiKhachHang + "," + this.dinhMucTieuThu  ;
    }
    public KhachHangVietNam() {
    }

    public String getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(String loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    public int getDinhMucTieuThu() {
        return dinhMucTieuThu;
    }

    public void setDinhMucTieuThu(int dinhMucTieuThu) {
        this.dinhMucTieuThu = dinhMucTieuThu;
    }

    @Override
    public String toString() {
        return ", KhachHangVietNam{" +
                super.toString() +
                "loaiKhachHang='" + loaiKhachHang + '\'' +
                ", dinhMucTieuThu='" + dinhMucTieuThu + '\'' +
                "} " ;
    }
}
