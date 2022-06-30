package module_casestudy;

import java.util.Scanner;

public class test {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String salary = "";
        do {
            System.out.print("Nhập lương: ");
            salary = scanner.nextLine();
            if (Check.CheckRegexSalary(salary)) {
                System.out.println(" nhập đúng số lương  ");
            } else {
                System.out.println("nhập sai số lương cần nhập lại");
            }
        } while (!Check.CheckRegexSalary(salary));
    }
}
