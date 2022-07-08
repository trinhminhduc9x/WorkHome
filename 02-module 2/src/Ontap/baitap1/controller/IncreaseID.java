package Ontap.baitap1.controller;

import Ontap.baitap1.model.GenuinePhone;
import Ontap.baitap1.model.HandbookPhone;
import Ontap.baitap1.util.ReadAndWrite;

import java.util.List;

public class IncreaseID {
    private static final String CSV_PATH_FILE = "src/data/CustomerCSV.csv";
    private static final String EMPLOYEE_CSV_PATH_FILE = "src/data/EmployeeCSV.csv";

    public static int increaseID() {
        List<GenuinePhone> list = ReadAndWrite.readeGnuinePhoneCSV(CSV_PATH_FILE);
        int id;
        if (list.isEmpty()) id = 1;
        else {
            boolean flag;
            do {
                flag = false;
                id = Integer.parseInt(list.get(list.size() - 1).getIdPhone()) + 1;
//                for (GenuinePhone c : list) {
//                    if (Integer.parseInt(c.getIdPhone()) == id) {
//                        id++;
//                        flag = true;
//                    }
//                }
            } while (flag);
        }
        return id;
    }
    public static int increaseEmployeeID() {
        List<HandbookPhone> list = ReadAndWrite.readHandbookPhoneCSV(EMPLOYEE_CSV_PATH_FILE);
        int id;
        if (list.isEmpty()) id = 1;
        else {
            boolean flag;
            do {
                flag = false;
                id = Integer.parseInt(list.get(list.size() - 1).getIdPhone()) + 1;
//                for (HandbookPhone e : list) {
//                    if (Integer.parseInt(e.getIdPhone()) == id) {
//                        id++;
//                        flag = true;
//                    }
//                }
            } while (flag);
        }
        return id;
    }
}
