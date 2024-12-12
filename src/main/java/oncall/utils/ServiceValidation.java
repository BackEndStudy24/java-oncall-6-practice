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
        if(day < 1 || day > 12) {
            throw new IllegalArgumentException(ErrorMessageType.ERROR_NUMBER_FORMAT_ERROR.getMessage());
        }
    }

}
