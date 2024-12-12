package oncall.constants;

public enum ErrorMessageType {

    ERROR_NULL("[ERROR] 공백은 입력할 수 없습니다. 다시 입력 해주세요."),
    ERROR_NUMBER_FORMAT_ERROR("[ERROR] 올바른 월 형식이 아닙니다. 다시 입력 해주세요."),
    ERROR_DAY_OF_THE_WEEK("[ERROR] 올바른 요일 형식이 아닙니다. 다시 입력 해주세요."),
    ERROR_DUPLICATE_NAME("[ERROR] 중복된 이름이 존재합니다. 다시 입력 해주세요."),
    ERROR_NAME_LENGTH("[ERROR] 이름은 최대 5자까지 입력 가능합니다. 다시 입력 해주세요."),
    ERROR_EMPLOYEE_STAFF("[ERROR] 최소/최대 근무 가능한 인원은 5~35명입니다. 다시 입력 해주세요."),
    ERROR_EMPLOYEE_STAFF_WORK("[ERROR] 근무자는 평일, 휴일에 모두 한 번씩 들어가야 합니다. 다시 입력 해주세요.");

    private final String message;

    ErrorMessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
