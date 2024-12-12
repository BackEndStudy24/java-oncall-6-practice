package oncall.constants;

public enum ErrorMessageType {

    ERROR_NULL("[ERROR] 공백은 입력할 수 없습니다. 다시 입력 해주세요."),
    ERROR_NUMBER_FORMAT_ERROR("[ERROR] 올바른 월 형식이 아닙니다. 다시 입력 해주세요."),
    ERROR_DAY_OF_THE_WEEK("[ERROR] 올바른 요일 형식이 아닙니다. 다시 입력 해주세요.");

    private final String message;

    ErrorMessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    }
