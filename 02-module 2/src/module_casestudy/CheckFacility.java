package module_casestudy;

import module_casestudy.model.facility.Facility;
import module_casestudy.model.facility.Villa;
import module_casestudy.model.person.Customer;
import module_casestudy.util.ReadAndWriteCSV;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckFacility {
    private static final String PATH_FILE_VILLA = "src/module_casestudy/data/FacilityVilla.csv";
    private static final String PATH_FILE_ROOM = "src/module_casestudy/data/FacilityRoom.csv";
    private static final String PATH_FILE_HOUSE = "src/module_casestudy/data/FacilityHouse.csv";
    private static final String NAME_REGEX = "^[A-Z](\\w+||\\s||\\w+)+$";
    private static final Map<Facility, Integer> facilityVillaIntegerMap = ReadAndWriteCSV.readListFacilityVillaToCSV(PATH_FILE_VILLA);
    private static final Map<Facility, Integer> facilityRoomIntegerMap = ReadAndWriteCSV.readListFacilityRoomToCSV(PATH_FILE_ROOM);
    private static final Map<Facility, Integer> facilityHouseIntegerMap = ReadAndWriteCSV.readListFacilityHouseToCSV(PATH_FILE_HOUSE);
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
    public static Boolean checkRoomName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            Set<Facility> keySet = facilityRoomIntegerMap.keySet();
            for (Facility key : keySet) {
                if (name.equals(key.getNameService())) {
                    check = false;
                    break;
                }

            }
        }
        return check;
    }
    public static Boolean checkHouseName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            Set<Facility> keySet = facilityHouseIntegerMap.keySet();
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

