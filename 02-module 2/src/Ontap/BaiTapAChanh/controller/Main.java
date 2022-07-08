package Ontap.BaiTapAChanh.controller;

import Ontap.BaiTapAChanh.model.HoaDon;
import Ontap.BaiTapAChanh.service.ServiceKhachHang;
import Ontap.BaiTapAChanh.service.impl.ServicerHoaDon;
import Ontap.BaiTapAChanh.service.impl.ServicerKhachHangimpl;

import java.util.Scanner;

public class Main {
    public static void displayMainMenu() {
        ServiceKhachHang serviceKhachHang;
        ServicerHoaDon servicerHoaDon;
        boolean flag = true;
        do {
            serviceKhachHang = new ServicerKhachHangimpl();
            servicerHoaDon = new ServicerHoaDon();
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Thêm mới khách hàng." +
                    "\n 2.Hiện thị thông tin khách hàng" +
                    "\n 3.Tìm kiếm khách hàng " +
                    "\n 4.Thêm mới hóa đơn" +
                    "\n 5.Chỉnh sửa hóa đơn" +
                    "\n 6.Hiện thị thông  tin chi tiết hóa đơn" +
                    "\n 7. Thoát");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("Thêm mới khách hàng.");
                    serviceKhachHang.themmoi();
                    break;
                case "2":
                    System.out.println("Hiện thị thông tin khách hàng");
                    serviceKhachHang.hienthi();
                    break;
                case "3":
                    System.out.println("Tìm kiếm khách hàng");
                    serviceKhachHang.timkiem();
                    break;
                case "4":
                    System.out.println("Thêm mới hóa đơn");
                    serviceKhachHang.hienthi();
                    servicerHoaDon.themmoi();
                    break;
                case "5":
                    System.out.println("Chỉnh sửa hóa đơn");
                    servicerHoaDon.hienthi();
                    servicerHoaDon.chinhsua();
                    servicerHoaDon.hienthi();
                    break;
                case "6":
                    System.out.println("Hiện thị thông  tin chi tiết hóa đơn");
                    servicerHoaDon.hienthi();
                    servicerHoaDon.timkiem();
                    break;
                case "7":
                    System.out.println("Thoát");
                    return;
                default:
                    System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (flag);
    }
}
