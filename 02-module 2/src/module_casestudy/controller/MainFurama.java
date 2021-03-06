package module_casestudy.controller;

import module_casestudy.service.BookingService;
import module_casestudy.service.CustomerService;
import module_casestudy.service.EmployeeService;
import module_casestudy.service.FacilityService;
import module_casestudy.service.impl.BookingServiceImpl;
import module_casestudy.service.impl.CustomerServiceImpl;
import module_casestudy.service.impl.EmployeeServiceImpl;
import module_casestudy.service.impl.FacilityServiceImpl;

import java.util.Scanner;

public class MainFurama {
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
                    customerManagementMenu();
                    break;
                case "3":
                    System.out.println("Chức năng Facility Management");
                    facilityManagementMenu();
                    break;
                case "4":
                    System.out.println("chức năng Booking Management");
                    bookingManagementMenu();
                    break;
                case "5":
                    System.out.println("chức năng Promotion Management");
                    promotionManagementMenu();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (flag);

    }

    private static void employeeManagementMenu() {
        EmployeeService employeeServices = null;
        boolean flag = true;
        do {
            employeeServices = new EmployeeServiceImpl();
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Display list employees" +
                    "\n 2.Add new employee" +
                    "\n 3.Edit employee" +
                    "\n 4.Delete employee" +
                    "\n 5.Return main menu");
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
                    System.out.println("Chức năng Edit employee");
                    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                    employeeService.delete();
                    break;
                case "5":
                    System.out.println("chức năng Return main menu");
                    return;
                default:
                    System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (flag);
    }

    private static void customerManagementMenu() {
        CustomerService customerService = null;
        boolean flag = true;
        do {
            customerService = new CustomerServiceImpl();
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Display list customer" +
                    "\n 2.Add new customer" +
                    "\n 3.Edit customer" +
                    "\n 4.Delete customer" +
                    "\n 5.Return main menu");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("chức năng Display list customer");
                    customerService.display();
                    break;
                case "2":
                    System.out.println("Chức năng Add new customer");
                    customerService.add();
                    break;
                case "3":
                    System.out.println("Chức năng Edit customer");
                    customerService.edit();
                    break;
                case "4":
                    System.out.println("Chức năng Delete customer");
                    CustomerServiceImpl customerService1 = new CustomerServiceImpl();
                    customerService1.delete();
                    break;
                case "5":
                    System.out.println("chức năng Return main menu");
                    return;
                default:
                    System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (flag);
    }

    private static void facilityManagementMenu() {
        FacilityService facilityService = null;
        boolean flag = true;
        do {
            facilityService = new FacilityServiceImpl();
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Display list facility" +
                    "\n 2.Add new facility" +
                    "\n 3.Edit facilityr" +
                    "\n 4.Return main menu");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("chức năng Display list facility");
                    facilityService.display();
                    break;
                case "2":
                    System.out.println("Chức năng Add new facility");
                    facilityService.add();
                    break;
                case "3":
                    System.out.println("Chức năng Edit facility");

                    break;
                case "4":
                    System.out.println("chức năng Return main menu");
                    return;
                default:
                    System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (flag);
    }

    private static void bookingManagementMenu() {
        BookingService bookingService = null;
        boolean flag = true;
        do {
            bookingService = new BookingServiceImpl();
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Add new booking" +
                    "\n 2.Display list booking" +
                    "\n 3.Create new constracts" +
                    "\n 4.Display list contracts" +
                    "\n 5.Edit contracts" +
                    "\n 6.Return main menu");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("chức năng Add new booking");
                    bookingService.add();
                    break;
                case "2":
                    System.out.println("Chức năng Display list booking");
                    bookingService.display();
                    break;
                case "3":
                    System.out.println("Chức năng Create new constracts");

                    break;
                case "4":
                    System.out.println("Chức năng Display list contracts");

                    break;
                case "5":
                    System.out.println("Chức năng Edit contracts");

                    break;
                case "6":
                    System.out.println("chức năng Return main menu");
                    return;
                default:
                    System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (flag);
    }

    private static void promotionManagementMenu() {
        boolean flag = true;
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Display list customers use service" +
                    "\n 2.Display list customers get voucher" +
                    "\n 3.Return main menu");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("chức năng Display list customers use service");

                    break;
                case "2":
                    System.out.println("Chức năng list customers get voucher");

                    break;
                case "3":
                    System.out.println("chức năng Return main menu");
                    return;
                default:
                    System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (flag);
    }
}