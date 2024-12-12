package oncall.controller;

import oncall.utils.ServiceValidation;
import oncall.view.InputView;

import java.util.List;

public class Controller {

    public void start() {
        clientInput_Month_Day();
        clientInput_WeekDayStaff();
        clientInput_HolidayStaff();
    }

    private void clientInput_Month_Day() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        List<String> rawMonthDay = InputView.getStringsUsingDelimiter();

        int month = ServiceValidation.validateIsNumeric(rawMonthDay.get(0)); // 4
        ServiceValidation.validateMonth(month);
        String day = ServiceValidation.validateDayOfTheWeek(rawMonthDay.get(1)); // 월
    }

    private void clientInput_WeekDayStaff() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        List<String> weekDayStaffs = InputView.getStringsUsingDelimiter();
        ServiceValidation.validateStaffs(weekDayStaffs);

    }

    private void clientInput_HolidayStaff() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        List<String> holidayStaffs = InputView.getStringsUsingDelimiter();
        ServiceValidation.validateStaffs(holidayStaffs);

    }
}
