//package baiTapThem.util;
//
//public class mau {
//    package case_study.util;
//
//import case_study.model.Car;
//import case_study.model.Motorcycle;
//import case_study.model.Producer;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//    public class WriteAndRead {
//        public static <E> void  writeToCSV(List<E> stringList, String pathFile, boolean append){
//            File file = new File(pathFile);
//            FileWriter fileWriter = null;
//            BufferedWriter bufferedWriter = null;
//            try {
//                fileWriter = new FileWriter(file);
//                bufferedWriter = new BufferedWriter(fileWriter);
//                for (E s: stringList) {
//                    bufferedWriter.write(s.toString());
//                    bufferedWriter.newLine();
//                }
//                bufferedWriter.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
////    public static void main(String[] args) {
////        List<Motorcycle> cars = new ArrayList<>();
////        writeToCSV(cars, "src/case_study/util/S.csv", true);
////    }
//
//        public static List<Car> readFileCSV(String pathFile){
//            List<Car> eList = new ArrayList<>();
//            File file = new File(pathFile);
//            FileReader fileReader = null;
//            BufferedReader bufferedReader = null;
//            String line = "";
//            String[] arr = null;
//            try {
//                fileReader = new FileReader(file);
//                bufferedReader = new BufferedReader(fileReader);
//                while ((line=bufferedReader.readLine())!=null){
//                    arr = line.split(",");
////                Producer producer= find(arr[1]);
//                    Car car = new Car(Integer.parseInt(arr[0]),new Producer(Integer.parseInt(arr[0]),arr[1],arr[2]),Integer.parseInt(arr[2]),arr[3],Integer.parseInt(arr[4]),arr[5]);
//
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }catch (IOException e){
//
//            }
//            return eList;
//        }
//    }
//}
