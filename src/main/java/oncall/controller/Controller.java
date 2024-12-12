package oncall.controller;

import oncall.utils.ServiceValidation;
import oncall.view.InputView;

import java.util.List;

public class Controller {

    public void start() {
        clientInput_Month_Day();
    }

    private void clientInput_Month_Day() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        List<String> rawMonthDay = InputView.getStringsUsingDelimiter();

        int month = ServiceValidation.validateIsNumeric(rawMonthDay.get(0));
        ServiceValidation.validateMonth(month);
        String day = ServiceValidation.validateDayOfTheWeek(rawMonthDay.get(1));

    }
}
