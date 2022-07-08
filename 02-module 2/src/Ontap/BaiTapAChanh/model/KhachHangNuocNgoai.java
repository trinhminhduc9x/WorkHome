package Ontap.BaiTapAChanh.model;

public class KhachHangNuocNgoai extends KhachHang{
    private String quocTich;

    public KhachHangNuocNgoai() {
    }
    public String getInfoToCSV() {
        return super.getInfoToCSV() + "," + this.quocTich  ;
    }
    public KhachHangNuocNgoai(int stt, String maKhachhang, String hoVaTen, String quocTich) {
        super(stt, maKhachhang, hoVaTen);
        this.quocTich = quocTich;
    }

    public KhachHangNuocNgoai(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    @Override
    public String toString() {
        return ", KhachHangNuocNgoai{" +
                super.toString() +
                "quocTich='" + quocTich + '\'' +
                "} " ;
    }
}
