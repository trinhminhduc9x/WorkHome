package Ontap.baitap1.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class CheckData {
    public static boolean checkAge(LocalDate age){
        LocalDate now = LocalDate.now();
        if( Period.between(age,now).getYears() <=2 ){
            return true;
        }else  return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập ngày sinh");
        LocalDate day = null;
        try{
            day  = LocalDate.parse(scanner.nextLine());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(day);
        LocalDate age = LocalDate.parse("1922-08-10");
        LocalDate now = LocalDate.now();
        System.out.println(Period.between(age,now).getYears());
        System.out.println(checkAge(age));
    }
//    public static boolean checkStartDay(LocalDate startDay){
//        LocalDate now = LocalDate.now();
//        if (Period.between(now,startDay).getDays() <0  ){
//
//            try {
//                throw new UserException("Ngày bắt đầu trước ngày hiện tại");
//
//            } catch (UserException e) {
//                e.printStackTrace();
//                return false;
//            }
//        }else return true;
//    }
//    public static boolean checkStartEndDay(LocalDate startDay,LocalDate endDay){
//        if(Period.between(startDay,endDay).getDays()<0){
//            try {
//                throw  new UserException("Ngày kết thúc trước ngày bắt đầu");
//            } catch (UserException e) {
//                e.printStackTrace();
//                return false;
//            }
//        }else return true;
//    }
}
