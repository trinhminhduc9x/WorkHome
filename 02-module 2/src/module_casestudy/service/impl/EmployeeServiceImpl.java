package module_casestudy.service.impl;


import module_casestudy.model.person.Employee;
import module_casestudy.service.EmployeeService;
import module_casestudy.util.ReadAndWriteCSV;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeServiceImpl implements EmployeeService {
    private Scanner scanner = new Scanner(System.in);
    private final String PATH_FILE = "src/module_casestudy/data/Employee.csv";
    private static Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_REGEX = "^\\d{9}||\\d{12}$";

    @Override
    public void display() {
        List<Employee> employeeList = ReadAndWriteCSV.readEmployeeList(PATH_FILE);
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println((1 + i) + ". " + employeeList.get(i));
        }
    }

    @Override
    public void add() {
        List<Employee> employeeList = new ArrayList<>();
        System.out.println("nhập id");
        String id = scanner.nextLine();
        System.out.println("nhập tên");
        String name = scanner.nextLine();
        //--------------------------------------
        //fix bug LocalDate
        LocalDate date;
        while (true) {
            try {
                System.out.println("nhập ngay sinh theo yyyy/MM/dd");
                date = LocalDate.parse(scanner.nextLine());
                break;
            } catch (DateTimeParseException e) {
                System.out.println("nhập ngay sinh theo yyyy/MM/dd ");
                e.printStackTrace();
            }
        }
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
        boolean check =true;
        String idNumber;
        do {
            Pattern pattern;
            Matcher matcher;
            Scanner scanner = new Scanner(System.in);
            System.out.println("nhập số CMND hoặc căn cước công dân");
            idNumber = scanner.nextLine();
            pattern = Pattern.compile(EMAIL_REGEX);
            matcher = pattern.matcher(idNumber);
            if (matcher.matches()) {
                System.out.println(" nhập đúng số CMND hoặc căn cước công dân");
                break;
            } else {
                System.out.println(" nhập không đúng số CMND hoặc căn cước công dân yêu cầu nhập lại");
                check = false;
            }
        } while (!check);
        System.out.println("nhập id Phone");
        int idPhone = Integer.parseInt(scanner.nextLine());
        System.out.println(" nhap email");
        String email = scanner.nextLine();
        System.out.println(" nhap levelEmployee");
        String level = scanner.nextLine();
        System.out.println(" nhap locationEmployee");
        String location = scanner.nextLine();
        System.out.println(" nhap salaryEmployee");

        int salary = Integer.parseInt(scanner.nextLine());

        Employee employee = new Employee(id, name, date, gioitinh, idNumber, idPhone, email, level, location, salary);
        employeeList.add(employee);
        ReadAndWriteCSV.writeEmployeeListToCSV(employeeList, PATH_FILE, true);
    }

    @Override
    public void edit() {
//        display();
//        List<Employee> employeeList = ReadAndWriteCSV.readEmployeeList(PATH_FILE);
//        System.out.println(" chon hoc vien can sua ");
//        int edit = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < employeeList.size(); i++) {
//            if (edit - 1 == i) {
//                System.out.println("nhập id");
//                employeeList.get(i).setId(scanner.nextLine());
//                System.out.println("nhập tên");
//                employeeList.get(i).setName(scanner.nextLine());
//                System.out.println("nhập ngay sinh");
//                employeeList.get(i).setDateOfBirth(LocalDate.parse(scanner.nextLine()));
//                System.out.println("gioi tinh");
//                employeeList.get(i).setGender(scanner.nextLine());
//                System.out.println("nhập id number");
//                employeeList.get(i).setIdNumber(Integer.parseInt(scanner.nextLine()));
//                System.out.println("nhập id Phone");
//                employeeList.get(i).setPhoneNumber(Integer.parseInt(scanner.nextLine()));
//                System.out.println(" nhap email");
//                employeeList.get(i).setEmail(scanner.nextLine());
//                System.out.println(" nhap levelEmployee");
//                employeeList.get(i).setLevelEmployee(scanner.nextLine());
//                System.out.println(" nhap locationEmployee");
//                employeeList.get(i).setLocationEmployee(scanner.nextLine());
//                System.out.println(" nhap salaryEmployee");
//                employeeList.get(i).setSalaryEmployee(Integer.parseInt(scanner.nextLine()));
//                ReadAndWriteCSV.writeEmployeeListToCSV(employeeList, PATH_FILE, false);
//                break;
//            }
//        }
//
//    }
    }
}
