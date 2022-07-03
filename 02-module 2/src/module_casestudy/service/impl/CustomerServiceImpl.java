package module_casestudy.service.impl;

import module_casestudy.Check;
import module_casestudy.model.person.Customer;
import module_casestudy.service.CustomerService;
import module_casestudy.util.ReadAndWriteCSV;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Customer> customerList = new ArrayList<>();
    private static final String PATH_FILE = "src/module_casestudy/data/Customer.csv";

    @Override
    public void display() {
        List<Customer> customerList = ReadAndWriteCSV.readCustomerList(PATH_FILE);
        if (customerList.isEmpty()) {
            System.out.println("Chưa có dữ liệu, mời bạn thêm vào.");
        } else {
            for (int i = 0; i < customerList.size(); i++) {
                System.out.println((1 + i) + ". " + customerList.get(i));
            }
        }
    }

    @Override
    public void add() {

        List<Customer> customerList1 = ReadAndWriteCSV.readCustomerList(PATH_FILE);
        String id = String.valueOf(customerList1.size() + 1);
        String name = "";
        do {
            System.out.println("nhập tên");
            name = scanner.nextLine();
            if (Check.checkCustomerName(name)) {
                System.out.println(" nhập đúng tên");
            } else {
                System.out.println(" nhập không đúng tên pháp yêu cầu nhập lại");
            }
        } while (!Check.checkCustomerName(name));

        LocalDate dateNow = LocalDate.now();
        boolean check;
        LocalDate date = null;
        do {
            try {
                System.out.println("nhập ngay sinh theo dd/MM/yyyy");
                String day = scanner.nextLine();
                date = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Period periodToNextJavaRelease = Period.between(date, dateNow);
                if (periodToNextJavaRelease.getYears() < 100 && periodToNextJavaRelease.getYears() > 18) {
                    System.out.println("bạn đã nhập đúng ");
                    break;
                }
                check = false;
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            } catch (DateTimeParseException e) {
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
                check = false;
            }
        } while (!check);

        String gioitinh = "";
        do {
            System.out.println("chọn giới tính " +
                    "\n 1.Nam" +
                    "\n 2.Nữ" +
                    "\n 3.LGBT" +
                    "\n 4.Giới tính khác");
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    gioitinh = "Nam";
                    break;
                case "2":
                    gioitinh = "Nư";
                    break;
                case "3":
                    gioitinh = "LGBT";
                    break;
                case "4":
                    gioitinh = "Giới tính khác";
                    break;
                default:
                    System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (gioitinh.equals(""));
        String idNumber = "";
        do {
            System.out.println("nhập số CMND gồm 9 số hoặc căn cước công dân gồm 11 số");
            idNumber = scanner.nextLine();
            if (Check.checkCustomerIdName(idNumber)) {
                System.out.println(" nhập đúng số CMND hoặc căn cước công dân");
                break;
            } else {
                System.out.println(" nhập không đúng số CMND hoặc căn cước công dân yêu cầu nhập lại");
            }
        } while (!Check.checkCustomerIdName(idNumber));
        String idPhone = "";
        do {
            System.out.println("nhập số điện thoại ");
            idPhone = scanner.nextLine();
            if (Check.checkCustomerPhone(idPhone)) {
                System.out.println(" nhập đúng số điện thoại");
                break;
            } else {
                System.out.println(" nhập không đúng số điện thoại yêu cầu nhập lại");
            }
        } while (!Check.checkCustomerPhone(idPhone));
        String email = "";
        do {
            System.out.println("nhập số email");
            email = scanner.nextLine();
            if (Check.checkCustomerEmail(email)) {
                System.out.println(" nhập đúng email");
                break;
            } else {
                System.out.println(" nhập không đúng email, yêu cầu nhập lại");
            }
        } while (!Check.checkCustomerEmail(email));
        System.out.println(" nhap type Customer");
        String level = "";
        String choose;
        do {
            System.out.println("Nhập trình độ\n" +
                    "1. Diamond.\n" +
                    "2. Platinium.\n" +
                    "3. Gold.\n" +
                    "4. Silver.\n" +
                    "5. Member.");
            System.out.print("Mời bạn chọn: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    level = "Diamond";
                    break;
                case "2":
                    level = "Platinium";
                    break;
                case "3":
                    level = "Gold";
                    break;
                case "4":
                    level = "Silver";
                    break;
                case "5":
                    level = "Member";
                    break;
                default:
                    System.out.println("Bạn chọn không đúng thông tin, mời bạn chọn lại");
            }
        } while (level.equals(""));
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        Customer customer = new Customer(id, name, date, gioitinh, idNumber, idPhone, email, level, address);
        customerList.add(customer);
        ReadAndWriteCSV.writeCustomerListToCSV(customerList, PATH_FILE, true);
    }

    @Override
    public void edit() {
        display();
        List<Customer> customerList = ReadAndWriteCSV.readCustomerList(PATH_FILE);
        System.out.println(" chon hoc vien can sua ");
        String edit = scanner.nextLine();
        for (int i = 0; i < customerList.size(); i++) {
            if (edit.equals(customerList.get(i).getId())) {
                String id = String.valueOf(i + 1);
                String name = "";
                do {
                    System.out.println("nhập tên");
                    name = scanner.nextLine();
                    if (Check.checkCustomerName(name)) {
                        System.out.println(" nhập đúng tên");
                    } else {
                        System.out.println(" nhập không đúng tên pháp yêu cầu nhập lại");
                    }
                } while (!Check.checkCustomerName(name));

                LocalDate dateNow = LocalDate.now();
                boolean check;
                LocalDate date = null;
                do {
                    try {
                        System.out.println("nhập ngay sinh theo dd/MM/yyyy");
                        String day = scanner.nextLine();
                        date = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        Period periodToNextJavaRelease = Period.between(date, dateNow);
                        if (periodToNextJavaRelease.getYears() < 100 && periodToNextJavaRelease.getYears() > 18) {
                            System.out.println("bạn đã nhập đúng ");
                            break;
                        }
                        check = false;
                        System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
                    } catch (DateTimeParseException e) {
                        System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
                        check = false;
                    }
                } while (!check);

                String gioitinh = "";
                do {
                    System.out.println("chọn giới tính " +
                            "\n 1.Nam" +
                            "\n 2.Nữ" +
                            "\n 3.LGBT" +
                            "\n 4.Giới tính khác");
                    System.out.println("Chọn chức năng");
                    String choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            gioitinh = "Nam";
                            break;
                        case "2":
                            gioitinh = "Nư";
                            break;
                        case "3":
                            gioitinh = "LGBT";
                            break;
                        case "4":
                            gioitinh = "Giới tính khác";
                            break;
                        default:
                            System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
                    }
                } while (gioitinh.equals(""));
                String idNumber = "";
                do {
                    System.out.println("nhập số CMND gồm 9 số hoặc căn cước công dân gồm 11 số");
                    idNumber = scanner.nextLine();
                    if (Check.checkCustomerIdName(idNumber)) {
                        System.out.println(" nhập đúng số CMND hoặc căn cước công dân");
                        break;
                    } else {
                        System.out.println(" nhập không đúng số CMND hoặc căn cước công dân yêu cầu nhập lại");
                    }
                } while (!Check.checkCustomerIdName(idNumber));
                String idPhone = "";
                do {
                    System.out.println("nhập số điện thoại ");
                    idPhone = scanner.nextLine();
                    if (Check.checkCustomerPhone(idPhone)) {
                        System.out.println(" nhập đúng số điện thoại");
                        break;
                    } else {
                        System.out.println(" nhập không đúng số điện thoại yêu cầu nhập lại");
                    }
                } while (!Check.checkCustomerPhone(idPhone));
                String email = "";
                do {
                    System.out.println("nhập số email");
                    email = scanner.nextLine();
                    if (Check.checkCustomerEmail(email)) {
                        System.out.println(" nhập đúng email");
                        break;
                    } else {
                        System.out.println(" nhập không đúng email, yêu cầu nhập lại");
                    }
                } while (!Check.checkCustomerEmail(email));
                System.out.println(" nhap type Customer");
                String level = "";
                String choose;
                do {
                    System.out.println("Nhập trình độ\n" +
                            "1. Diamond.\n" +
                            "2. Platinium.\n" +
                            "3. Gold.\n" +
                            "4. Silver.\n" +
                            "5. Member.");
                    System.out.print("Mời bạn chọn: ");
                    choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            level = "Diamond";
                            break;
                        case "2":
                            level = "Platinium";
                            break;
                        case "3":
                            level = "Gold";
                            break;
                        case "4":
                            level = "Silver";
                            break;
                        case "5":
                            level = "Member";
                            break;
                        default:
                            System.out.println("Bạn chọn không đúng thông tin, mời bạn chọn lại");
                    }
                } while (level.equals(""));
                System.out.print("Nhập địa chỉ: ");
                String address = scanner.nextLine();
                customerList.get(i).setId(id);
                customerList.get(i).setName(name);
                customerList.get(i).setDateOfBirth(date);
                customerList.get(i).setGender(gioitinh);
                customerList.get(i).setIdNumber(idNumber);
                customerList.get(i).setPhoneNumber(idPhone);
                customerList.get(i).setEmail(email);
                customerList.get(i).setTypeCustomer(level);
                customerList.get(i).setAddress(address);
                ReadAndWriteCSV.writeCustomerListToCSV(customerList, PATH_FILE, false);
                break;
            }
        }
    }

    public void delete() {
        List<Customer> customerList = ReadAndWriteCSV.readCustomerList(PATH_FILE);
        display();
        System.out.println(" nhap hoc vien can xoa");
        int delete = Integer.parseInt(scanner.nextLine());
        customerList.remove(delete - 1);
        for (int i = 0; i < customerList.size(); i++) {
            customerList.get(i).setId(String.valueOf(1 + i));
        }
        ReadAndWriteCSV.writeCustomerListToCSV(customerList, PATH_FILE, false);
    }

}
