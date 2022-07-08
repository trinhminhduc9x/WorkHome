package Ontap.BaiTapAChanh.common;

import Ontap.BaiTapAChanh.model.HoaDon;
import Ontap.BaiTapAChanh.model.KhachHang;
import Ontap.BaiTapAChanh.util.ReadAndWriteCSV;
import module_casestudy.model.person.Customer;
import module_casestudy.model.person.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
    private static final String HOADON_PATH_CSV = "src/Ontap/BaiTapAChanh/data/HoaDon.csv";
    private static final String NAME_REGEX = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)+$";
    private static final String NAME_HD_REGEX = "^(KHVN_0000|KHNN_0000)\\d+$";
    private static final String NAMEID_HD_REGEX = "^(MHD_00)\\d+$";
    private static final String KHACHHANG_PATH_CSV = "src/Ontap/BaiTapAChanh/data/KhachHang.csv";
    private static final   List<KhachHang> khachHangList = ReadAndWriteCSV.readkhachhangToCSV(KHACHHANG_PATH_CSV);


    public static boolean checkIncreaseNNID() {
        boolean flag =true;
        List<KhachHang> khachHangList = ReadAndWriteCSV.readkhachhangToCSV(KHACHHANG_PATH_CSV);
        for (KhachHang k: khachHangList) {
            if (k.getMaKhachhang().contains("KHNN")){
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static boolean checkIncreaseVNID() {
        boolean flag = true;
        List<KhachHang> khachHangList = ReadAndWriteCSV.readkhachhangToCSV(KHACHHANG_PATH_CSV);
        for (KhachHang k: khachHangList) {
            if (k.toString().contains("KHVN")){
                flag=false;
                break;
            }
        }
        return flag;
    }



    public static Boolean checkKhachHangName(String name) {

        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (int i = 0; i < khachHangList.size(); i++) {
                if (name.equals(khachHangList.get(i).getHoVaTen())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean checkMaKhachHang(String name) {

        Pattern pattern = Pattern.compile(NAME_HD_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (int i = 0; i < khachHangList.size(); i++) {
                if (name.equals(khachHangList.get(i).getMaKhachhang())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean checRegexkMaHoaDon(String name) {

        Pattern pattern = Pattern.compile(NAMEID_HD_REGEX);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static Boolean checRegexkKhachHangName(String name) {

        Pattern pattern = Pattern.compile(NAME_HD_REGEX);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        do {
            System.out.println("nhập tên");
            name = scanner.nextLine();
            if (Check.checRegexkKhachHangName(name)) {
                System.out.println(" nhập đúng tên");
            } else {
                System.out.println(" nhập không đúng tên pháp yêu cầu nhập lại");
            }
        } while (!Check.checRegexkKhachHangName(name));

    }
}
