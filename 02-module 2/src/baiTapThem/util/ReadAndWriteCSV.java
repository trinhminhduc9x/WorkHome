package baiTapThem.util;
import baiTapThem.model.Truck;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class ReadAndWriteCSV {
    public static void writeListToCSV(List<Truck> truckList, String pathFile) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            for( Truck s : truckList) {
                bufferedWriter.write(s.getToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Truck> employeeList(String pathFile) {
        List<Truck> truckList = new ArrayList<>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        String[] array = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                Truck truck = new Truck(array[0], array[1],array[2], array[3],Double.parseDouble(array[4]));
                truckList.add(truck);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
        return truckList;
    }
}
