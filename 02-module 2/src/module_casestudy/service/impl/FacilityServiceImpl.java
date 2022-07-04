package module_casestudy.service.impl;

import module_casestudy.CheckFacility;
import module_casestudy.model.facility.Facility;
import module_casestudy.model.facility.House;
import module_casestudy.model.facility.Room;
import module_casestudy.model.facility.Villa;
import module_casestudy.service.FacilityService;
import module_casestudy.util.ReadAndWriteCSV;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FacilityServiceImpl implements FacilityService {
    private static final String PATH_FILE_VILLA = "src/module_casestudy/data/Villa.csv";
    private static final String PATH_FILE_HOUSE = "src/module_casestudy/data/House.csv";
    private static final String PATH_FILE_ROOM = "src/module_casestudy/data/Room.csv";
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        boolean flag = true;
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Display New Villa" +
                    "\n 2.Display New House" +
                    "\n 3.Display New Room" +
                    "\n 4.Display All" +
                    "\n 5.Back to menu");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("chức năng display New Villa");
                    displayVilla();
                    break;
                case "2":
                    System.out.println("Chức năng display New House");
                    displayHouse();
                    break;
                case "3":
                    System.out.println("Chức năng display New Room");
                    displayRoom();
                    break;
                case "4":
                    System.out.println("chức năng display all");
                    displayVilla();
                    displayHouse();
                    displayRoom();
                    break;
                case "5":
                    System.out.println("chức năng Back to menu");
                    return;
                default:
                    System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (flag);
    }


    @Override
    public void add() {
        boolean flag = true;
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Add New Villa" +
                    "\n 2.Add New House" +
                    "\n 3.Add New Room" +
                    "\n 4.Back to menu");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("chức năng Add New Villa");
                    addNewVilla();
                    break;
                case "2":
                    System.out.println("Chức năng Add New House");
                    addNewHouse();
                    break;
                case "3":
                    System.out.println("Chức năng Add New Room");
                    addNewRoom();
                    break;
                case "4":
                    System.out.println("chức năng Back to menu");
                    return;
                default:
                    System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (flag);
    }

    @Override
    public void edit() {

    }

    private static void addNewVilla() {
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        Map<Facility, Integer> facilityIntegerMapNewV = ReadAndWriteCSV.readListFacilityVillaToCSV(PATH_FILE_VILLA);
        String idService ="SVVL-" + String.valueOf(facilityIntegerMapNewV.size() + 1);
        String nameService;
        do {
            System.out.println("nhập tên");
            nameService = scanner.nextLine();
            if (CheckFacility.checkVillaName(nameService)) {
                System.out.println(" nhập đúng tên");
            } else {
                System.out.println(" nhập không đúng tên pháp yêu cầu nhập lại");
            }
        } while (!CheckFacility.checkVillaName(nameService));

        double usableArea;
        while (true) {
            try {
                System.out.println("nhập diện tích sử dụng");
                usableArea = Double.parseDouble(scanner.nextLine());
                System.out.println("bạn đã nhập đúng ");
                break;
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            }
        }

        double rentalCosts;
        while (true) {
            try {
                System.out.println("nhập chi phí thuê");
                rentalCosts = Double.parseDouble(scanner.nextLine());
                System.out.println("bạn đã nhập đúng ");
                break;
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            }
        }

        int maximumNumOfPeople;
        while (true) {
            try {
                System.out.println("nhập số lượng người tối đa");
                maximumNumOfPeople = Integer.parseInt(scanner.nextLine());
                System.out.println("bạn đã nhập đúng ");
                break;
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            }
        }


        String rentalType = "";
        do {
            System.out.println("chọn kiểu thuê " +
                    "\n 1.Năm" +
                    "\n 2.Tháng" +
                    "\n 3.Ngày" +
                    "\n 4.Giơ");
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    rentalType = "Năm";
                    break;
                case "2":
                    rentalType = "Tháng";
                    break;
                case "3":
                    rentalType = "Ngày";
                    break;
                case "4":
                    rentalType = "Giờ";
                    break;
                default:
                    System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (rentalType.equals(""));


        System.out.println("nhập tiêu chuẩn phòng");
        String roomStandard = scanner.nextLine();

        double swimmingPoolArea;
        while (true) {
            try {
                System.out.println("nhập diện tích hồ bơi");
                swimmingPoolArea = Double.parseDouble(scanner.nextLine());
                System.out.println("bạn đã nhập đúng ");
                break;
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            }
        }

        int numOfFloor;
        while (true) {
            try {
                System.out.println("nhập số tầng");
                numOfFloor = Integer.parseInt(scanner.nextLine());
                System.out.println("bạn đã nhập đúng ");
                break;
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            }
        }


        Facility facility = new Villa(idService, nameService, usableArea, rentalCosts, maximumNumOfPeople, rentalType, roomStandard, swimmingPoolArea, numOfFloor);
        Map<Facility, Integer> facilityIntegerMapInt = ReadAndWriteCSV.readListFacilityVillaToCSV(PATH_FILE_VILLA);
        facilityIntegerMap.put(facility, facilityIntegerMapInt.size() + 1);
        ReadAndWriteCSV.writeListFacilityToCSV(facilityIntegerMap, PATH_FILE_VILLA, true);

    }


    private void addNewHouse() {
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        Map<Facility, Integer> facilityIntegerMapNewH = ReadAndWriteCSV.readListFacilityHouseToCSV(PATH_FILE_HOUSE);
        String idService = "SVHO-" + String.valueOf(facilityIntegerMapNewH.size() + 1);
        String nameService;
        do {
            System.out.println("nhập tên");
            nameService = scanner.nextLine();
            if (CheckFacility.checkHouseName(nameService)) {
                System.out.println(" nhập đúng tên");
            } else {
                System.out.println(" nhập không đúng tên pháp yêu cầu nhập lại");
            }
        } while (!CheckFacility.checkHouseName(nameService));

        double usableArea;
        while (true) {
            try {
                System.out.println("nhập diện tích sử dụng");
                usableArea = Double.parseDouble(scanner.nextLine());
                System.out.println("bạn đã nhập đúng ");
                break;
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            }
        }

        double rentalCosts;
        while (true) {
            try {
                System.out.println("nhập chi phí thuê");
                rentalCosts = Double.parseDouble(scanner.nextLine());
                System.out.println("bạn đã nhập đúng ");
                break;
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            }
        }

        int maximumNumOfPeople;
        while (true) {
            try {
                System.out.println("nhập số lượng người tối đa");
                maximumNumOfPeople = Integer.parseInt(scanner.nextLine());
                System.out.println("bạn đã nhập đúng ");
                break;
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            }
        }


        String rentalType = "";
        do {
            System.out.println("chọn kiểu thuê " +
                    "\n 1.Năm" +
                    "\n 2.Tháng" +
                    "\n 3.Ngày" +
                    "\n 4.Giơ");
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    rentalType = "Năm";
                    break;
                case "2":
                    rentalType = "Tháng";
                    break;
                case "3":
                    rentalType = "Ngày";
                    break;
                case "4":
                    rentalType = "Giờ";
                    break;
                default:
                    System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (rentalType.equals(""));


        System.out.println("nhập tiêu chuẩn phòng");
        String roomStandard = scanner.nextLine();


        int numOfFloor;
        while (true) {
            try {
                System.out.println("nhập số tầng");
                numOfFloor = Integer.parseInt(scanner.nextLine());
                System.out.println("bạn đã nhập đúng ");
                break;
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            }
        }


        Facility facility = new House(idService, nameService, usableArea, rentalCosts, maximumNumOfPeople, rentalType, roomStandard, numOfFloor);
        Map<Facility, Integer> facilityIntegerMapInt = ReadAndWriteCSV.readListFacilityHouseToCSV(PATH_FILE_HOUSE);
        facilityIntegerMap.put(facility, facilityIntegerMapInt.size() + 1);
        ReadAndWriteCSV.writeListFacilityToCSV(facilityIntegerMap, PATH_FILE_HOUSE, true);
    }


    private void addNewRoom() {
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        Map<Facility, Integer> facilityIntegerMapNewR = ReadAndWriteCSV.readListFacilityVillaToCSV(PATH_FILE_ROOM);
        String idService = "SVRO-" + String.valueOf(facilityIntegerMapNewR.size() + 1);
        String nameService;
        do {
            System.out.println("nhập tên");
            nameService = scanner.nextLine();
            if (CheckFacility.checkRoomName(nameService)) {
                System.out.println(" nhập đúng tên");
            } else {
                System.out.println(" nhập không đúng tên pháp yêu cầu nhập lại");
            }
        } while (!CheckFacility.checkRoomName(nameService));

        double usableArea;
        while (true) {
            try {
                System.out.println("nhập diện tích sử dụng");
                usableArea = Double.parseDouble(scanner.nextLine());
                System.out.println("bạn đã nhập đúng ");
                break;
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            }
        }

        double rentalCosts;
        while (true) {
            try {
                System.out.println("nhập chi phí thuê");
                rentalCosts = Double.parseDouble(scanner.nextLine());
                System.out.println("bạn đã nhập đúng ");
                break;
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            }
        }

        int maximumNumOfPeople;
        while (true) {
            try {
                System.out.println("nhập số lượng người tối đa");
                maximumNumOfPeople = Integer.parseInt(scanner.nextLine());
                System.out.println("bạn đã nhập đúng ");
                break;
            } catch (NumberFormatException e) {
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            }
        }


        String rentalType = "";
        do {
            System.out.println("chọn kiểu thuê " +
                    "\n 1.Năm" +
                    "\n 2.Tháng" +
                    "\n 3.Ngày" +
                    "\n 4.Giơ");
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    rentalType = "Năm";
                    break;
                case "2":
                    rentalType = "Tháng";
                    break;
                case "3":
                    rentalType = "Ngày";
                    break;
                case "4":
                    rentalType = "Giờ";
                    break;
                default:
                    System.out.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (rentalType.equals(""));

        System.out.println("nhập dịch vụ miễn phí đi kèm ");
        String freeService = scanner.nextLine();
        Facility facility = new Room(idService, nameService, usableArea, rentalCosts, maximumNumOfPeople, rentalType, freeService);
        Map<Facility, Integer> facilityIntegerMapInt = ReadAndWriteCSV.readListFacilityRoomToCSV(PATH_FILE_ROOM);
        facilityIntegerMap.put(facility, facilityIntegerMapInt.size() + 1);
        ReadAndWriteCSV.writeListFacilityToCSV(facilityIntegerMap, PATH_FILE_ROOM, true);
    }


    public void displayVilla() {
        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteCSV.readListFacilityVillaToCSV(PATH_FILE_VILLA);
        if (facilityIntegerMap.isEmpty()) {
            System.out.println("Chưa có dữ liệu, mời bạn thêm vào.");
        } else {
            Set<Facility> keySet = facilityIntegerMap.keySet();
            for (Facility key : keySet) {
                System.out.println(key + " " + facilityIntegerMap.get(key));
            }
        }
    }

    public void displayHouse() {
        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteCSV.readListFacilityHouseToCSV(PATH_FILE_HOUSE);
        if (facilityIntegerMap.isEmpty()) {
            System.out.println("Chưa có dữ liệu, mời bạn thêm vào.");
        } else {
            Set<Facility> keySet = facilityIntegerMap.keySet();
            for (Facility key : keySet) {
                System.out.println(key + " " + facilityIntegerMap.get(key));
            }
        }
    }

    public void displayRoom() {
        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteCSV.readListFacilityRoomToCSV(PATH_FILE_ROOM);
        if (facilityIntegerMap.isEmpty()) {
            System.out.println("Chưa có dữ liệu, mời bạn thêm vào.");
        } else {
            Set<Facility> keySet = facilityIntegerMap.keySet();
            for (Facility key : keySet) {
                System.out.println(key + " " + facilityIntegerMap.get(key));
            }
        }
    }
}
