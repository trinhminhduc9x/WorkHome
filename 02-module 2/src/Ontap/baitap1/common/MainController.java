package Ontap.baitap1.common;

import Ontap.baitap1.service.IGenuinePhoneSevice;
import Ontap.baitap1.service.impl.GenuinePhoneSeviceImpl;
import module_casestudy.service.EmployeeService;
import module_casestudy.service.impl.EmployeeServiceImpl;

import java.util.Scanner;

public class MainController {
    static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        IGenuinePhoneSevice iGenuinePhoneSevice;
        boolean flag = true;
        do {
            iGenuinePhoneSevice = new GenuinePhoneSeviceImpl();
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.adđ" +
                    "\n 2.display" +
                    "\n 3.Edit employee" +
                    "\n 4.Delete employee" +
                    "\n 5.Return main menu");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("chức năng Display list employees");
                    iGenuinePhoneSevice.add();
                    break;
                case "2":
                    System.out.println("Chức năng Add new employee");
                    iGenuinePhoneSevice.display();
                    break;
                case "3":
                    System.out.println("Chức năng Edit employee");

                    break;
                case "4":
                    System.out.println("Chức năng Edit employee");

                    break;
                case "5":
                    System.out.println("chức năng Return main menu");
                    return;
                default:
                    System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (flag);
    }

}
