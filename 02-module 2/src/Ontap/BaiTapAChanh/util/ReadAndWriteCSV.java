package Ontap.BaiTapAChanh.util;

import Ontap.BaiTapAChanh.model.HoaDon;
import Ontap.BaiTapAChanh.model.KhachHang;
import Ontap.BaiTapAChanh.model.KhachHangNuocNgoai;
import Ontap.BaiTapAChanh.model.KhachHangVietNam;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCSV {


    public static List<String> readObjectToCSV(String pathFile) {
        List<String> list = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(pathFile));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private static void writeObjectToCSV(List<String> list, String pathFile, boolean append) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(pathFile, append));
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write(list.get(i));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<KhachHang> readkhachhangToCSV(String pathFile) {
        List<KhachHang> khachHangList = new ArrayList<>();
        List<String> list = readObjectToCSV(pathFile);
        String[] arr;
        for (int i = 0; i < list.size(); i++) {
            arr = list.get(i).split(",");
            if (arr[1].contains("KHVN")) {
                khachHangList.add(new KhachHangVietNam(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], Integer.parseInt(arr[4])));
            } else if (arr[1].contains("KHNN")) {
                khachHangList.add(new KhachHangNuocNgoai(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3]));
            }
        }
        return khachHangList;
    }

    public static void writeKhachHangToCSV(List<KhachHang> khachHangList, String pathFile, boolean append) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < khachHangList.size(); i++) {
            list.add(khachHangList.get(i).getInfoToCSV());
        }
        writeObjectToCSV(list, pathFile, append);
    }
    public static List<HoaDon> readhoadonToCSV(String pathFile) {
        List<HoaDon> hoaDonList = new ArrayList<>();
        List<String> list = readObjectToCSV(pathFile);
        String[] arr;
        for (int i = 0; i < list.size(); i++) {
            arr = list.get(i).split(",");
                hoaDonList.add(new HoaDon(Integer.parseInt(arr[0]), arr[1], arr[2], LocalDate.parse(arr[3]), Integer.parseInt(arr[4]),Integer.parseInt(arr[5]),Integer.parseInt(arr[6])));
        }
        return hoaDonList;
    }

    public static void writeHoaDonToCSV(List<HoaDon> hoaDonList, String pathFile, boolean append) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < hoaDonList.size(); i++) {
            list.add(hoaDonList.get(i).getInfoToCSV());
        }
        writeObjectToCSV(list, pathFile, append);
    }
}
