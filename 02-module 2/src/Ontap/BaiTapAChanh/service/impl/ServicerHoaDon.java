package Ontap.BaiTapAChanh.service.impl;

import Ontap.BaiTapAChanh.common.Check;
import Ontap.BaiTapAChanh.common.IncreaseID;
import Ontap.BaiTapAChanh.model.HoaDon;
import Ontap.BaiTapAChanh.model.KhachHang;
import Ontap.BaiTapAChanh.model.KhachHangNuocNgoai;
import Ontap.BaiTapAChanh.model.KhachHangVietNam;
import Ontap.BaiTapAChanh.util.ReadAndWriteCSV;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicerHoaDon implements Ontap.BaiTapAChanh.service.ServicerHoaDon {
    private static final String HOADON_PATH_CSV = "src/Ontap/BaiTapAChanh/data/HoaDon.csv";
    private static final String KHACHHANG_PATH_CSV = "src/Ontap/BaiTapAChanh/data/KhachHang.csv";
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void themmoi() {
        List<KhachHang> khachHangList = ReadAndWriteCSV.readkhachhangToCSV(KHACHHANG_PATH_CSV);
        int stt = IncreaseID.inHd();
        String sttten = IncreaseID.increaseHD();
        String name = "";
        do {
            System.out.println("nhập mã khách hàng");
            name = scanner.nextLine();
            if (Check.checRegexkKhachHangName(name)) {
                System.out.println(" nhập đúng mã khách hàng theo KHVN-0000 hoặc KHNN-0000 ");
            } else {
                System.out.println(" nhập không đúng mã khách hàng pháp yêu cầu nhập lại");
            }
        } while (!Check.checRegexkKhachHangName(name));

        LocalDate dateNow = LocalDate.now();
        boolean check;
        LocalDate startDay = null;
        do {
            try {
                System.out.println("nhập ra hóa đơn bắt đầu theo dd/MM/yyyy và trong 100 năm gần đây");
                String day = scanner.nextLine();
                startDay = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Period periodToNextJavaRelease = Period.between(startDay, dateNow);
                if (periodToNextJavaRelease.getYears() < 100) {
                    System.out.println("bạn đã nhập đúng ");
                    break;
                }
                check = false;
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            } catch (DateTimeParseException e) {
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
                check = false;
            }
        } while (!check);


        int soluong;
        while (true) {
            try {
                System.out.println("nhap so luong");
                soluong = Integer.parseInt(scanner.nextLine());
                System.out.println("bạn đã nhập đúng ");
                break;
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            }
        }

        int dongia;
        while (true) {
            try {
                System.out.println("nhap dong gia");
                dongia = Integer.parseInt(scanner.nextLine());
                System.out.println("bạn đã nhập đúng ");
                break;
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            }
        }
        int thanhtien = 0;


        for (KhachHang k : khachHangList) {
            if (k instanceof KhachHangVietNam) {
                if (k.getMaKhachhang().equals(name)) {
                    if (soluong > ((KhachHangVietNam) k).getDinhMucTieuThu()) {
                        thanhtien = soluong * dongia + (soluong - ((KhachHangVietNam) k).getDinhMucTieuThu()) * dongia * 2;
                        break;
                    } else {
                        thanhtien = soluong * dongia;
                        break;
                    }
                }
            }
            if (k instanceof KhachHangNuocNgoai) {
                if (k.getMaKhachhang().equals(name)) {
                    thanhtien = soluong * dongia;
                }
            }

        }


        List<HoaDon> hoaDonList = new ArrayList<>();
        HoaDon hoaDon = new HoaDon(stt, sttten, name, startDay, soluong, dongia, thanhtien);
        hoaDonList.add(hoaDon);
        ReadAndWriteCSV.writeHoaDonToCSV(hoaDonList, HOADON_PATH_CSV, true);
    }

    @Override
    public void hienthi() {

        List<HoaDon> hoaDonList = ReadAndWriteCSV.readhoadonToCSV(HOADON_PATH_CSV);
        for (HoaDon c : hoaDonList) {
            System.out.println(c);
        }
    }

    @Override
    public void timkiem() {
        System.out.println(" chon hoa don can chin sua ");
        String name = "";
        do {
            System.out.println("nhập mã hoa don");
            name = scanner.nextLine();
            if (Check.checRegexkMaHoaDon(name)) {
                System.out.println(" nhập đúng mã hoa don ");
            } else {
                System.out.println(" nhập không đúng mã khách hàng pháp yêu cầu nhập lại");
            }
        } while (!Check.checRegexkMaHoaDon(name));
        String maKhachHang = "";
        List<HoaDon> hoaDonList = ReadAndWriteCSV.readhoadonToCSV(HOADON_PATH_CSV);
        for (HoaDon c : hoaDonList) {
            if (name.equals(c.getMaHoaDon())) {
                maKhachHang = c.getMaKhachHang();
                break;
            }
        }
        int count = 0;
        List<KhachHang> khachHangList = ReadAndWriteCSV.readkhachhangToCSV(KHACHHANG_PATH_CSV);
        for (KhachHang c : khachHangList) {
            if (c.getMaKhachhang().contains(maKhachHang)) {
                System.out.println(c);
                count++;
            }
        }
        if (count == 0) {
            System.out.println(" không có tên cần tìm");
        }

    }

    @Override
    public void chinhsua() {
        System.out.println(" chon hoa don can chin sua ");
        String name = "";
        do {
            System.out.println("nhập mã hoa don");
            name = scanner.nextLine();
            if (Check.checRegexkMaHoaDon(name)) {
                System.out.println(" nhập đúng mã khách hàng theo KHVN-0000 hoặc KHNN-0000 ");
            } else {
                System.out.println(" nhập không đúng mã khách hàng pháp yêu cầu nhập lại");
            }
        } while (!Check.checRegexkMaHoaDon(name));


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


        List<HoaDon> hoaDonList = ReadAndWriteCSV.readhoadonToCSV(HOADON_PATH_CSV);
        for (HoaDon c : hoaDonList) {
            if (name.equals(c.getMaHoaDon())) {
                c.setMaKhachHang(namenew);
                break;
            }
        }
        ReadAndWriteCSV.writeHoaDonToCSV(hoaDonList, HOADON_PATH_CSV, false);
        System.out.println("đã sửa thành công ");
    }
}
