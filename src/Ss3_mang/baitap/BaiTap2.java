package Ss3_mang.baitap;

import java.util.Arrays;
import java.util.Scanner;

public class BaiTap2 {
    public static void main(String[] args) {
        int[] arr = ToArr();
        System.out.println("Mảng mới nhập là: "+ Arrays.toString(arr));
        inCludes(arr);

    }
    public static int[] ToArr() {
        int[] array ;
        int size;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(" Nhập số phần tử của mảng");
            size = scanner.nextInt();
            if (size>20){
                System.out.println(" số phần tử của mảng vượt quá số quy định ");
            }
        }while (size>20);
        array = new int[size];
        int i=0 ;
        while (i < array.length){
            System.out.println(" Nhập số phần tử " + (i + 1)+": ");
            array [i] = scanner.nextInt();
            i++;
        }
        return array;
    }
    public static void inCludes(int[] array){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" nhập tên cần xoa ");
        int input_name = scanner.nextInt();
        boolean isExist = false ;
        int[] arrayNew= new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayNew[i]=array[i];
            if (array[i]==(input_name)){
                System.out.println("tên của bạn có trong danh sách: " + input_name+ " có số thứ tự là : " +(i+1));
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
