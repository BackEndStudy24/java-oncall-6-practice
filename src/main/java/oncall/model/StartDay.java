package oncall.model;

import oncall.constants.HolidayType;
import oncall.constants.WeekType;
import oncall.constants.WorkingType;

public class StartDay {

    private int month;
    private String strDay;

    public void outputCalendar(int month, int finalDay) {

        for(int i = 1; i <= finalDay; i++ ){
            String strDay = getWeekTypeStrDay(i);
            String output = String.format("%d월 %d일 %s\n", month, i, strDay);
            if(HolidayType.checkedHoliday(output)== (WorkingType.HOLIDAY)) {
                System.out.printf("%d월 %d일 %s(휴일)\n", month, i, strDay);
            } else {
                System.out.print(output);
            }
        }
    }

    private String getWeekTypeStrDay(int nextDay) {
        int day = WeekType.checkedWeekInt(strDay);
        return WeekType.checkedWeek(day+nextDay-1);
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setStrDay(String strDay) {
        this.strDay = strDay;
    }

    public int getMonth() {
        return month;
    }

    public String getStrDay() {
        return strDay;
    }
}
