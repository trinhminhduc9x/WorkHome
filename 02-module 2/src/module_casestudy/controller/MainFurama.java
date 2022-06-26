package module_casestudy.controller;

import module_casestudy.service.impl.EmployeeServiceImpl;

import java.util.Scanner;

public class MainFurama {
    private static final EmployeeServiceImpl employeeServices = new EmployeeServiceImpl();

    public static void displayMainMenu() {
        boolean flag = true;
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Employee Management" +
                    "\n 2.Customer Management" +
                    "\n 3.Facility Management " +
                    "\n 4.Booking Management" +
                    "\n 5.Promotion Management" +
                    "\n 6. Exit");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("chức năng Employee Management");
                    employeeManagementMenu();
                    break;
                case "2":
                    System.out.println("Chức năng Customer Management");

                    break;
                case "3":
                    System.out.println("Chức năng Facility Management");


                    break;
                case "4":
                    System.out.println("chức năng Booking Management");

                    break;
                case "5":
                    System.out.println("chức năng Promotion Management");

                    break;
                case "6":
                    flag = false;

                    break;
                default:
                    System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (flag);

    }

    private static void employeeManagementMenu() {
                boolean flag = true;
                do {
                    System.out.println("Chức năng của hệ thống " +
                            "\n 1.Display list employees" +
                            "\n 2.Add new employee" +
                            "\n 3.Edit employee" +
                            "\n 4.Return main menu");
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Chọn chức năng");
                    String choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            System.out.println("chức năng Display list employees");
                            employeeServices.display();
                            break;
                        case "2":
                            System.out.println("Chức năng Add new employee");
                            employeeServices.add();
                            break;
                        case "3":
                            System.out.println("Chức năng Edit employee");
                            employeeServices.edit();
                            break;
                        case "4":
                            System.out.println("chức năng Return main menu");
                            flag = false;
                            break;
                default:
                    System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
                    }
                } while (flag);
    }
}
