package baiTapThem.controller;


import baiTapThem.service.impl.IMotorbikeService;
import baiTapThem.service.impl.ITourCarService;
import baiTapThem.service.impl.ITruckService;

import java.util.Scanner;

public class MainCar {
    private static IMotorbikeService iMotorbikeService = new IMotorbikeService();
    private static ITourCarService iTourCarService = new ITourCarService();
    private static ITruckService iTruckService = new ITruckService();

    public static void displayMainMenu() {
        boolean flag = true;
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Add" +
                    "\n 2.Display" +
                    "\n 3.Delete" +
                    "\n 4.Search" +
                    "\n 5.Exit");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:

                    System.out.println("chức năng them moi");
                    addMainMenuCar();
                    break;
                case 2:
                    System.out.println("Chức năng hien thi");
                    displayMainMenuCar();
                    break;
                case 3:
                    // code xóa
                    System.out.println("chức năng xóa");
                    deleteMainMenuCar();
                    break;
                case 4:
                    // code sửa

                    System.out.println("chức năng tìm");
                    searchMainMenuCar();
                    break;

                default:
                    flag = false;
            }
        } while (flag);
    }

    private static void addMainMenuCar() {
        boolean flag = true;
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.add truck" +
                    "\n 2.add tour car" +
                    "\n 3.add motorbike" +
                    "\n 4. Exit");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("chức năng them xe tai");
                    iTruckService.add();
                    break;
                case 2:
                    System.out.println("Chức năng them oto");
                    iTourCarService.add();
                    break;
                case 3:
                    System.out.println("chức năng them xe may");
                    iMotorbikeService.add();
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }

    private static void displayMainMenuCar() {
        boolean flag = true;
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.display truck" +
                    "\n 2.display tour car" +
                    "\n 3.display motorbike" +
                    "\n 4. Exit");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("chức năng hien thi xe tai");
                    iTruckService.dispaly();
                    break;
                case 2:
                    System.out.println("Chức năng hien thi oto");
                    iTourCarService.dispaly();
                    break;
                case 3:
                    System.out.println("chức năng hien thi xe may");
                    iMotorbikeService.dispaly();
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }

    private static void deleteMainMenuCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap vao bien kiem xoat ");
        String bienKiemXoat = scanner.nextLine();
        iTourCarService.delete(bienKiemXoat);
        iTruckService.delete(bienKiemXoat);
        iMotorbikeService.delete(bienKiemXoat);
    }
    private static void searchMainMenuCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" can  nhap vao bien kiem xoat ");
        String bienKiemXoat = scanner.nextLine();
      iTourCarService.searchByName(bienKiemXoat);
      iTruckService.searchByName(bienKiemXoat);
      iMotorbikeService.searchByName(bienKiemXoat);
    }

}

