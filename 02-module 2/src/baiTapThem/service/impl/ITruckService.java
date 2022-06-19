package baiTapThem.service.impl;

import baiTapThem.model.Truck;
import baiTapThem.service.IServiceCar;
import demo.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class ITruckService implements IServiceCar {

    Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Truck> trucksList = new ArrayList<Truck>();

    static {
        trucksList.add(new Truck("5", "asd", "Asd", "asd", 123));
        trucksList.add(new Truck("6", "asd", "Asd", "asd", 123));
        trucksList.add(new Truck("4", "asd", "Asd", "asd", 123));
        trucksList.add(new Truck("2", "asd", "Asd", "asd", 123));
    }

    @Override
    public void add() {

        System.out.println("nhập bien kiem soat");
        String bienKiemSoat = scanner.nextLine();
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
        trucksList.add(truck);
    }

    @Override
    public void dispaly() {
        for (Object s : trucksList) {
            System.out.println(s);
        }
    }

    @Override
    public void searchByName(String name) {
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
        for (int i = 0; i < trucksList.size(); i++) {
            if (name.equals(trucksList.get(i).getBienKiemSoat())) {
                System.out.println("Chức năng của hệ thống " +
                        "\n 1.yes" +
                        "\n 2.No");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Chọn chức năng");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        System.out.println("chức năng them moi");
                        trucksList.remove(i);
                        System.out.println("da xoa thanh cong");
                        break;
                    case 2:
                        System.out.println("Chức năng hien thi");
                        break;
                }
                break;
            }

        }
    }

}
