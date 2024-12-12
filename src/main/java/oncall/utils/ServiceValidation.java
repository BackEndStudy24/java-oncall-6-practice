package oncall.utils;

import oncall.constants.ErrorMessageType;

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

    public static void validateNegativeNumber(int day) {
        if (day < 1 || day > 12) {
            throw new IllegalArgumentException(ErrorMessageType.ERROR_NUMBER_FORMAT_ERROR.getMessage());
        }
    }

    public static void validateDayOfTheWeek(String input) {
        if (input.equals("월") || input.equals("화") || input.equals("수") || input.equals("목") || input.equals("금") || input.equals("토") || input.equals("일")) {
            throw new IllegalArgumentException(ErrorMessageType.ERROR_DAY_OF_THE_WEEK.getMessage());
        }
    }

}
