package Ontap.baitap1.util;

import Ontap.baitap1.model.GenuinePhone;
import Ontap.baitap1.model.HandbookPhone;
import Ontap.baitap1.model.Phone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    private static List<String> readObjectToCSV(String pathFile) {
        List<String> strings = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(pathFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strings;
    }

    private static void writeObjectToCSV(List<String> strings, String pathFile, boolean append) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(pathFile, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < strings.size(); i++) {
                bufferedWriter.write(strings.get(i));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    public static List<GenuinePhone> readeGnuinePhoneCSV(String pathFile) {
        List<GenuinePhone>genuinePhoneList = new ArrayList<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] arr;
        for (int i = 0; i < strings.size(); i++) {
            arr = strings.get(i).split(",");

            genuinePhoneList.add(new GenuinePhone(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5],arr[6]));
        }
        return genuinePhoneList;
    }

    public static List<HandbookPhone> readHandbookPhoneCSV(String pathFile) {
        List<HandbookPhone>handbookPhoneList = new ArrayList<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] arr;
        for (int i = 0; i < strings.size(); i++) {
            arr = strings.get(i).split(",");

            handbookPhoneList.add(new HandbookPhone(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]));
        }
        return handbookPhoneList;
    }


    public static void writeGenuinePhoneToCSV(List<GenuinePhone> genuinePhoneList, String pathFile, boolean append) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < genuinePhoneList.size(); i++) {
            strings.add(genuinePhoneList.get(i).getInfoToCSV());
        }
        writeObjectToCSV(strings, pathFile, append);
    }
    public static void writeHandbookPhoneToCSV(List<HandbookPhone> handbookPhoneList, String pathFile, boolean append) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < handbookPhoneList.size(); i++) {
            strings.add(handbookPhoneList.get(i).getInfoToCSV());
        }
        writeObjectToCSV(strings, pathFile, append);
    }
}
