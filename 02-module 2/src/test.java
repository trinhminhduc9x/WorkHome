import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    private static final String EMAIL_REGEX = "^\\d{9}||\\d{12}$";

    public static void main(String[] args) {
        boolean check =true;
        do {
            Pattern pattern;
            Matcher matcher;
            Scanner scanner = new Scanner(System.in);
            System.out.println("nhập số CMND hoặc căn cước công dân");
            String idNumber = scanner.nextLine();
            pattern = Pattern.compile(EMAIL_REGEX);
            matcher = pattern.matcher(idNumber);
            if (matcher.matches()) {
                System.out.println(" nhập đúng số CMND hoặc căn cước công dân");
                break;
            } else {
                System.out.println(" nhập không đúng số CMND hoặc căn cước công dân yêu cầu nhập lại");
                check = false;
            }
        } while (!check);

//    while (true){
//        try {
//            Pattern pattern;
//            Matcher matcher;
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("nhập số CMND hoặc căn cước công dân");
//            String idNumber = scanner.nextLine();
//            pattern = Pattern.compile(EMAIL_REGEX);
//            matcher = pattern.matcher(idNumber);
//            System.out.println(" nhập đúng số CMND hoặc căn cước công dân");
//            matcher.matches()==true ;
//            break;
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println(" nhập không đúng số CMND hoặc căn cước công dân yêu cầu nhập lại");
//        }
        //   }
    }
}
