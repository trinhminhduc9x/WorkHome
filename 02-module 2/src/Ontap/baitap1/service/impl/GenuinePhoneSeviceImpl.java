package Ontap.baitap1.service.impl;

import Ontap.baitap1.model.GenuinePhone;
import Ontap.baitap1.model.Phone;
import Ontap.baitap1.service.IGenuinePhoneSevice;
import Ontap.baitap1.util.ReadAndWrite;
import module_casestudy.model.person.Customer;
import module_casestudy.util.ReadAndWriteCSV;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenuinePhoneSeviceImpl implements IGenuinePhoneSevice {
    static Scanner scanner = new Scanner(System.in);
    private final String PATH_FILE_GENUINE = "src/Ontap/baitap1/data/GenuinePhone.csv";
    @Override
    public void add() {
        System.out.println(" nhập id điện thoại ");
        String idPhone = scanner.nextLine();
        System.out.println(" nhập tên điện thoại ");
        String namePhone = scanner.nextLine();
        System.out.println(" nhập giá điện thoại ");
        String costPhone = scanner.nextLine();
        System.out.println("  nhập số lượng điện thoại ");
        String numberPhone = scanner.nextLine();
        System.out.println(" nhập nơi sảng xuất điện thoại ");
        String producerPhone = scanner.nextLine();
        System.out.println(" nhập nơi thời gian bảo hành điện thoại ");
        String timephoner = scanner.nextLine();
        System.out.println(" nhập nơi phảm vi bảo hành điện thoại ");
        String coveragePhone = scanner.nextLine();
        List<GenuinePhone> genuinePhones = new ArrayList<>();
        genuinePhones.add(new GenuinePhone(idPhone,namePhone,costPhone,numberPhone,producerPhone,timephoner,coveragePhone));
        ReadAndWrite.writeGenuinePhoneToCSV(genuinePhones, PATH_FILE_GENUINE, true);
    }

    @Override
    public void display() {
        List<GenuinePhone> genuinePhoneList = ReadAndWrite.readeGnuinePhoneCSV(PATH_FILE_GENUINE);
        if (genuinePhoneList.isEmpty()) {
            System.out.println("Chưa có dữ liệu, mời bạn thêm vào.");
        } else {
            for (int i = 0; i < genuinePhoneList.size(); i++) {
                System.out.println((1 + i) + ". " + genuinePhoneList.get(i));
            }
        }
    }

    @Override
    public void editById(String id) {

    }

    @Override
    public void deleteById(String id) {

    }
}
