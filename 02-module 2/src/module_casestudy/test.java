package module_casestudy;

import module_casestudy.model.facility.Facility;
import module_casestudy.util.ReadAndWriteCSV;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    private static final String PATH_FILE_VILLA = "src/module_casestudy/data/FacilityVilla.csv";
    private static final String PATH_FILE_ROOM = "src/module_casestudy/data/FacilityRoom.csv";
    private static final String NAME_REGEX = "^[A-Z][a-z]+(\\s\\w+)+$";
    private static final Map<Facility, Integer> facilityVillaIntegerMap = ReadAndWriteCSV.readListFacilityVillaToCSV(PATH_FILE_VILLA);
    private static final Map<Facility, Integer> facilityRoomIntegerMap = ReadAndWriteCSV.readListFacilityRoomToCSV(PATH_FILE_ROOM);
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Ádasdf");
        String name = scanner.nextLine();
        checkVillaName(name);
    }
    public static Boolean checkVillaName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            Set<Facility> keySet = facilityVillaIntegerMap.keySet();
            for (Facility key : keySet) {
                if (name.equals(key.getNameService())) {
                    check = false;
                    break;
                }

            }
        }
        return check;
    }
}
