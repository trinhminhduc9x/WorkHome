package baiTapThem.service.impl;


import baiTapThem.controller.MainCar;
import baiTapThem.model.TourCar;
import baiTapThem.service.IServiceCar;

import java.util.ArrayList;
import java.util.Scanner;

public class ITourCarService implements IServiceCar {

    Scanner scanner = new Scanner(System.in);
    private static final ArrayList<TourCar> tourCarsList = new ArrayList<TourCar>();

    static {
        tourCarsList.add(new TourCar("1", "asd", "Asd", "asd", 123, "kieu xe"));
        tourCarsList.add(new TourCar("2", "asd", "Asd", "asd", 123, "kieu xe"));
        tourCarsList.add(new TourCar("3", "asd", "Asd", "asd", 123, "kieu xe"));
        tourCarsList.add(new TourCar("4", "asd", "Asd", "asd", 123, "kieu xe"));

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
        System.out.println("nhập so cho ngoi ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println(" nhap kieu xe");
        String kieuXe = scanner.nextLine();

        TourCar tourCar = new TourCar(bienKiemSoat, temHangSanXuat, namSanXuat, chuSoHuu, id, kieuXe);
        // them mới dùng add()
        tourCarsList.add(tourCar);
    }

    @Override
    public void dispaly() {
        for (Object s : tourCarsList) {
            System.out.println(s);
        }
    }



    @Override
    public void delete(String name) {
        for (int i = 0; i < tourCarsList.size(); i++) {
            if (name.equals(tourCarsList.get(i).getBienKiemSoat())) {
                System.out.println("Chức năng của hệ thống " +
                        "\n 1.yes" +
                        "\n 2.No");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Chọn chức năng");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        System.out.println("chức năng them moi");
                        tourCarsList.remove(i);
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

    @Override
    public void searchByName(String name) {
        int count =0;
        for (int i = 0; i < tourCarsList.size(); i++) {
            if (name.equals(tourCarsList.get(i).getBienKiemSoat())) {
                System.out.println(tourCarsList.get(i));
                count++;
                break;
            }
            }
        if (count==0){
            System.out.println(" ko co phuong tien duoc tim thay");
        }
    }
}
