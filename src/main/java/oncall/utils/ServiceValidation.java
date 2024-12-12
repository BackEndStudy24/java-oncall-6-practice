package oncall.utils;

import oncall.constants.ErrorMessageType;
import oncall.model.Staff;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class ServiceValidation {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");

    public static void validateNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessageType.ERROR_NULL.getMessage());
        }
    }

    public static int validateIsNumeric(String input) {
        try {
            if (!NUMBER_PATTERN.matcher(input).matches()) {
                throw new IllegalArgumentException(ErrorMessageType.ERROR_NUMBER_FORMAT_ERROR.getMessage());
            }
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageType.ERROR_NUMBER_FORMAT_ERROR.getMessage());
        }
    }

    public static void validateMonth(int day) {
        if (day < 1 || day > 12) {
            throw new IllegalArgumentException(ErrorMessageType.ERROR_NUMBER_FORMAT_ERROR.getMessage());
        }
    }

    public static String validateDayOfTheWeek(String input) {
        if (!input.equals("월") && !input.equals("화") && !input.equals("수") && !input.equals("목") && !input.equals("금") && !input.equals("토") && !input.equals("일")) {
            throw new IllegalArgumentException(ErrorMessageType.ERROR_DAY_OF_THE_WEEK.getMessage());
        }
        return input;
    }

    public static void validateStaffs(List<String> staffs) {
        validateDuplicateName(staffs);
        validateNameLength(staffs);
        validateMinimumStaff(staffs);
    }

    private static void validateDuplicateName(List<String> staffs) {
        Set<String> setStaffs = new HashSet<>(staffs);
        if(setStaffs.size() != staffs.size()) {
            throw new IllegalArgumentException(ErrorMessageType.ERROR_DUPLICATE_NAME.getMessage());
        }
    }

    private static void validateNameLength(List<String> staffs) {
        for(String staff : staffs) {
            if (staff.length() > 5) {
                throw new IllegalArgumentException(ErrorMessageType.ERROR_NAME_LENGTH.getMessage());
            }
        }
    }

    private static void validateMinimumStaff(List<String> staffs) {
        if (staffs.size() < 5 || staffs.size() > 35) {
            throw new IllegalArgumentException(ErrorMessageType.ERROR_EMPLOYEE_STAFF.getMessage());
        }
    }

    public static void validateStaffTwoTimes(List<String> weekdayStaffs, List<String> holidayStaffs) {
        List<String> addStaffs = new ArrayList<>();
        addStaffs.addAll(weekdayStaffs);
        addStaffs.addAll(holidayStaffs);

        Set<String> setStaffs = new HashSet<>(addStaffs);

        if((((weekdayStaffs.size() + holidayStaffs.size())/2.0) != setStaffs.size() * 10 / 10.0)) {
            throw new IllegalArgumentException(ErrorMessageType.ERROR_EMPLOYEE_STAFF_WORK.getMessage());
        }
    }

}
