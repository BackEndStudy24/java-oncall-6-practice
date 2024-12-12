package oncall.controller;

import oncall.constants.MonthType;
import oncall.model.StaffHoliday;
import oncall.model.StaffWeekday;
import oncall.model.StartDay;
import oncall.utils.ServiceValidation;
import oncall.view.InputView;

import java.util.List;

public class Controller {

    final StaffHoliday staffHoliday = new StaffHoliday();
    final StaffWeekday staffWeekday = new StaffWeekday();
    final StartDay startDay = new StartDay(staffHoliday, staffWeekday);

    public void start() {

        runWithRetry(this::clientInput_Month_Day); // 메서드1

        boolean completed = false;
        while (!completed) {
            try {
                resetStaffInputs();
                clientInput_WeekDayStaff();
                clientInput_HolidayStaff();
                completed = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        print_Calendar(startDay.getMonth());

    }

    private void resetStaffInputs() {
        // 오류 발생 시 StaffWeekday와 StaffHoliday 초기화
        staffWeekday.clearWeekdayStaffs();
        staffHoliday.clearHolidayStaffs();
    }


    private void clientInput_Month_Day() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        List<String> rawMonthDay = InputView.getStringsUsingDelimiter();

        int month = ServiceValidation.validateIsNumeric(rawMonthDay.get(0)); // 4
        ServiceValidation.validateMonth(month);
        String strDay = ServiceValidation.validateDayOfTheWeek(rawMonthDay.get(1)); // 월

        startDay.setMonth(month);
        startDay.setStrDay(strDay);

    }

    private void clientInput_WeekDayStaff() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        List<String> weekDayStaffs = InputView.getStringsUsingDelimiter();
        ServiceValidation.validateStaffs(weekDayStaffs);
        staffWeekday.inputWeekDayStaffs(weekDayStaffs);
    }

    private void clientInput_HolidayStaff() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        List<String> holidayStaffs = InputView.getStringsUsingDelimiter();
        ServiceValidation.validateStaffs(holidayStaffs);
        staffHoliday.inputHolidayStaffs(holidayStaffs);
        ServiceValidation.validateStaffTwoTimes(staffWeekday.getWeekDayStaffsSize(), staffHoliday.getHolidayStaffsSize());

    }

    private void print_Calendar(int month) {
        int day = MonthType.checkedDay(month);

        startDay.outputCalendar(month, day);
    }

    private void runWithRetry(Runnable serviceMethod) {
        boolean success = false;
        while (!success) {
            try {
                serviceMethod.run();
                success = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
