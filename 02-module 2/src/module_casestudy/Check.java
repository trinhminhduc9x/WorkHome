package module_casestudy;

import module_casestudy.model.person.Employee;
import module_casestudy.util.ReadAndWriteCSV;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
    private static final String PATH_FILE = "src/module_casestudy/data/Employee.csv";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private static final String PHONE_REGEX = "^(84|0[3|5|7|8|9])+([0-9]{8})$";
    private static final String IDNAME_REGEX = "^\\d{9}||\\d{12}$";
    private static final String SAlARY_REGEX = "^\\d+$";
    private static final String NAME_REGEX = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)+$";
    private static final List<Employee> employeeList = ReadAndWriteCSV.readEmployeeList(PATH_FILE);


    public static Boolean CheckRegexEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (int i = 0; i < employeeList.size(); i++) {
                if (email.equals(employeeList.get(i).getEmail())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean CheckRegexPhone(String phone) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (int i = 0; i < employeeList.size(); i++) {
                if (phone.equals(employeeList.get(i).getPhoneNumber())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean CheckRegexIdName(String idname) {
        Pattern pattern = Pattern.compile(IDNAME_REGEX);
        Matcher matcher = pattern.matcher(idname);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (int i = 0; i < employeeList.size(); i++) {
                if (idname.equals(employeeList.get(i).getIdNumber())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean CheckRegexName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (int i = 0; i < employeeList.size(); i++) {
                if (name.equals(employeeList.get(i).getName())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean CheckRegexSalary(String name) {
        Pattern pattern = Pattern.compile(SAlARY_REGEX);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}