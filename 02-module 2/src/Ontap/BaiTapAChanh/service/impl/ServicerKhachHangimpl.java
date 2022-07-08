package Ontap.BaiTapAChanh.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Ontap.BaiTapAChanh.common.IncreaseID;
import Ontap.BaiTapAChanh.model.KhachHang;
import Ontap.BaiTapAChanh.model.KhachHangNuocNgoai;
import Ontap.BaiTapAChanh.model.KhachHangVietNam;
import Ontap.BaiTapAChanh.service.ServiceKhachHang;
import Ontap.BaiTapAChanh.util.ReadAndWriteCSV;
import module_casestudy.Check;

public class ServicerKhachHangimpl implements ServiceKhachHang {
    private static final String KHACHHANG_PATH_CSV = "src/Ontap/BaiTapAChanh/data/KhachHang.csv";
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void themmoi() {
        boolean flag = true;
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Thêm mới khách hàng nước ngoài." +
                    "\n 2.Thêm mới khách hàng Việt Nam" +
                    "\n 3. Thoát");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("Thêm mới khách hàng nước ngoài");
                    themmoiNN();
                    break;
                case "2":
                    System.out.println("Thêm mới khách hàng Việt Nam");
                    themmoiVN();
                    break;
                case "3":
                    System.out.println("Thoát");
                    return;
                default:
                    System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (flag);
    }

    @Override
    public void hienthi() {
        List<KhachHang> khachHangList = ReadAndWriteCSV.readkhachhangToCSV(KHACHHANG_PATH_CSV);
        for (KhachHang c : khachHangList) {
            System.out.println(c);
        }
    }

    @Override
    public void timkiem() {
        System.out.println(" nhập tên cần tìm ");
        int count= 0;
        String name = scanner.nextLine();
        List<KhachHang> khachHangList = ReadAndWriteCSV.readkhachhangToCSV(KHACHHANG_PATH_CSV);
        for (KhachHang c : khachHangList) {
            if (c.getHoVaTen().contains(name)){
                System.out.println(c);
                count++;
            }
        }
        if (count==0){
            System.out.println(" không có tên cần tìm");
        }
    }

    @Override
    public void chinhsua() {

    }
    private static void themmoiVN() {
        int stt = IncreaseID.increaseVNSTT();
        String sttten = IncreaseID.increaseVNID();
        String hovaten = "";
        do {
            System.out.println("nhập họ và tên");
            hovaten = scanner.nextLine();
            if (Check.checkCustomerName(hovaten)) {
                System.out.println(" nhập đúng tên");
            } else {
                System.out.println(" nhập không đúng tên pháp yêu cầu nhập lại");
            }
        } while (!Check.checkCustomerName(hovaten));
        String loaikhachang ="";
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.sinh hoạt." +
                    "\n 2.kinh doanh" +
                    "\n 2.sản xuất" +
                    "\n 3.Thoát");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    loaikhachang = "Thêm mới sinh hoạt";
                    break;
                case "2":
                    loaikhachang = "Thêm mới kinh doanh";
                    break;
                case "3":
                    loaikhachang = "Thêm mới sản xuất";
                    break;
                case "4":
                    System.out.println("Thoát");
                    return;
                default:
                    System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (loaikhachang.equals(""));

        int dinhmuctieuthu;
        while (true) {
            try {
                System.out.println("định mức tiêu thụ");
                dinhmuctieuthu = Integer.parseInt(scanner.nextLine()) ;
                System.out.println("bạn đã nhập đúng ");
                break;
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            }
        }
        List<KhachHang> khachHangList = new ArrayList<>();
        KhachHangVietNam khachHangVietNam = new KhachHangVietNam(stt, sttten, hovaten, loaikhachang,dinhmuctieuthu);
        khachHangList.add(khachHangVietNam);
        ReadAndWriteCSV.writeKhachHangToCSV(khachHangList, KHACHHANG_PATH_CSV, true);

    }

    private static void themmoiNN() {
        int stt = IncreaseID.increaseNNSTT();
        String sttten = IncreaseID.increaseNNID();
        String hovaten = "";
        do {
            System.out.println("nhập họ và tên");
            hovaten = scanner.nextLine();
            if (Check.checkCustomerName(hovaten)) {
                System.out.println(" nhập đúng tên");
            } else {
                System.out.println(" nhập không đúng tên pháp yêu cầu nhập lại");
            }
        } while (!Check.checkCustomerName(hovaten));


        System.out.println("nhập quốc tịch ");
        String quoctich = scanner.nextLine();
        List<KhachHang> khachHangList = new ArrayList<>();
        KhachHangNuocNgoai khachHangNuocNgoai = new KhachHangNuocNgoai(stt, sttten, hovaten, quoctich);
        khachHangList.add(khachHangNuocNgoai);
        ReadAndWriteCSV.writeKhachHangToCSV(khachHangList, KHACHHANG_PATH_CSV, true);
    }
}
