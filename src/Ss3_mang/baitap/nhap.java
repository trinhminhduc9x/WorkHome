package Ss3_mang.baitap;

import java.util.Arrays;
import java.util.Scanner;

public class nhap {
    public static void main(String[] args) {
        int[] array = {2,5,3,9,4,5,1,10,8,9};
        Scanner scanner = new Scanner(System.in);
        System.out.println(" nhập tên cần xoa ");
        int input_name = scanner.nextInt();
        boolean isExist = false ;
        int[] arrayNew= new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayNew[i]=array[i];
            if (array[i]==(input_name)){
                System.out.println("tên của bạn có trong danh sách: " + input_name+ " là : " +(i+1));
                for (int j = i+1 ; j <array.length ; j++) {
                    arrayNew[i]=array[j];
                    i++;
                }
                isExist=true;
                break;
            }
        }
        if (!isExist){
            System.out.println(" không có  " +input_name + " trong danh sách ");
        }
        System.out.println("Mảng đã thay là : "+ Arrays.toString(arrayNew));
    }

}
