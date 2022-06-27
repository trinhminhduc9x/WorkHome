package baiTapThem.service.impl;

import baiTapThem.model.Truck;
import baiTapThem.service.IServiceCar;
import baiTapThem.util.ReadAndWriteCSV;
import demo.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ITruckService implements IServiceCar {
    private static final String PATH_FILE = "src/baiTapThem/data/truck.csv";
    Scanner scanner = new Scanner(System.in);

    // kiem tra bien so trung lap
    public Boolean kiemTra(String x) {
        List<Truck> truckList = new ArrayList<>();
        boolean flag = true;
        for (Truck s : truckList) {
            if (s.getBienKiemSoat().equals(x)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Override
    public void add() {
        System.out.println("nhập bien kiem soat");
        String bienKiemSoat = scanner.nextLine();
        if (!kiemTra(bienKiemSoat)) {
            return;
        }
        System.out.println("nhập ten hang san xuat");
        String temHangSanXuat = scanner.nextLine();
        System.out.println(" nhap nam san xuat");
        String namSanXuat = scanner.nextLine();
        System.out.println(" nhap chu so huu");
        String chuSoHuu = scanner.nextLine();
        System.out.println("nhập trong tai ");
        double id = Double.parseDouble(scanner.nextLine());
        Truck truck = new Truck(bienKiemSoat, temHangSanXuat, namSanXuat, chuSoHuu, id);
        // them mới dùng add()
        List<Truck> trucksList = new ArrayList<Truck>();
        trucksList.add(truck);
        ReadAndWriteCSV.writeListToCSV(trucksList, PATH_FILE, true);
    }

    @Override
    public void dispaly() {
        List<Truck> trucksList = ReadAndWriteCSV.employeeList(PATH_FILE);
        for (int i = 0; i < trucksList.size(); i++) {
            System.out.println((1 + i) + ". " + trucksList.get(i));
        }
    }

    @Override
    public void searchByName(String name) {
        List<Truck> trucksList = ReadAndWriteCSV.employeeList(PATH_FILE);
        int count =0;
        for (int i = 0; i < trucksList.size(); i++) {
            if (name.equals(trucksList.get(i).getBienKiemSoat())) {
                System.out.println(trucksList.get(i));
                count++;
                break;
            }
        }
        if (count==0){
            System.out.println(" ko co phuong tien duoc tim thay");
        }
    }

    @Override
    public void delete(String name) {
        List<Truck> trucksList = ReadAndWriteCSV.employeeList(PATH_FILE);
        dispaly();
        for (int i = 0; i < trucksList.size(); i++) {
            if (name.equals(trucksList.get(i).getBienKiemSoat())) {
                System.out.println("bạn có chắc chắn xóa không " +
                        "\n 1.yes" +
                        "\n 2.No");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Chọn chức năng");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        System.out.println("chức năng xóa ");
                        trucksList.remove(i);
                        ReadAndWriteCSV.writeListToCSV(trucksList, PATH_FILE, false);
                        System.out.println("da xoa thanh cong");
                        break;
                    case 2:
                        System.out.println("không xóa thoát ra ngoài");
                        break;
                }
                break;
            }

        }
    }


}
