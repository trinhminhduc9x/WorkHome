package Ontap.BaiTapAChanh.common;
import Ontap.BaiTapAChanh.model.HoaDon;
import Ontap.BaiTapAChanh.model.KhachHang;
import Ontap.BaiTapAChanh.util.ReadAndWriteCSV;

import java.util.List;
import java.util.Scanner;
public class IncreaseID {
    private static final String HOADON_PATH_CSV = "src/Ontap/BaiTapAChanh/data/HoaDon.csv";
    private static final String KHACHHANG_PATH_CSV = "src/Ontap/BaiTapAChanh/data/KhachHang.csv";
    static Scanner scanner = new Scanner(System.in);
    public static int increaseNNSTT() {
        List<KhachHang> khachHangList = ReadAndWriteCSV.readkhachhangToCSV(KHACHHANG_PATH_CSV);
        int stt;
        if (Check.checkIncreaseNNID()) {
            stt=1;
        } else {
            stt=khachHangList.get(khachHangList.size() - 1).getStt() + 1;
        }
        return stt;
    }
    public static int increaseVNSTT() {
        List<KhachHang> khachHangList = ReadAndWriteCSV.readkhachhangToCSV(KHACHHANG_PATH_CSV);
        int stt;
        if (Check.checkIncreaseVNID()) {
            stt=1;
        } else {
            stt=khachHangList.get(khachHangList.size() - 1).getStt() + 1;
        }
        return stt;
    }
    public static String increaseNNID() {
        List<KhachHang> khachHangList = ReadAndWriteCSV.readkhachhangToCSV(KHACHHANG_PATH_CSV);
        String id;
        if (Check.checkIncreaseNNID()) {
            id = "KHNN_0000" + "1";
        } else {
            id = "KHNN_0000" + String.valueOf(khachHangList.get(khachHangList.size() - 1).getStt() + 1);
        }
        return id;
    }

    public static String increaseVNID() {
        List<KhachHang> khachHangList = ReadAndWriteCSV.readkhachhangToCSV(KHACHHANG_PATH_CSV);
        String id = null;
        if (Check.checkIncreaseVNID()) {
            id = "KHVN_0000" + "1";
        } else {
            id = "KHVN_0000" + String.valueOf(khachHangList.get(khachHangList.size() - 1).getStt() + 1);
        }
        return id;
    }
    public static int inHd() {
        List<HoaDon> hoaDonList = ReadAndWriteCSV.readhoadonToCSV(HOADON_PATH_CSV);
        int stt;
        if (hoaDonList.isEmpty()) {
            stt=1;
        } else {
            stt=hoaDonList.get(hoaDonList.size() - 1).getStt() + 1;
        }
        return stt;
    }
    public static String increaseHD() {
        List<HoaDon> hoaDonList = ReadAndWriteCSV.readhoadonToCSV(HOADON_PATH_CSV);
        String id = null;
        if (hoaDonList.isEmpty()) {
            id = "MHD_00" + "1";
        } else {
            id = "MHD_00" + String.valueOf(hoaDonList.get(hoaDonList.size() - 1).getStt() + 1);
        }
        return id;
    }

    public static void main(String[] args) {
        String namenew = "";
        do {
            System.out.println("nhập mã khách hàng");
            namenew = scanner.nextLine();
            if (Check.checkMaKhachHang(namenew)) {
                System.out.println(" nhập đúng mã khách hàng theo " + "MKH-00  ");
            } else {
                System.out.println(" nhập không đúng mã khách hàng pháp yêu cầu nhập lại");
            }
        } while (!Check.checkMaKhachHang(namenew));
    }
}
