package oncall.model;

import oncall.constants.HolidayType;
import oncall.constants.WeekType;

import java.util.List;

public class StartDay {

    private int month;
    private String strDay;
    private final StaffWeekday weekday;
    private final StaffHoliday holiday;


    public StartDay(StaffHoliday holiday, StaffWeekday weekday) {
        this.holiday = holiday;
        this.weekday = weekday;
    }

    public void outputCalendar(int month, int finalDay) {
        int holidayCount = 0;
        int weekDayCount = 0;

        for (int i = 1; i <= finalDay; i++) {
            String strDay = getWeekTypeStrDay(i); // 이게 만약 토 , 일 이거나 /

            String output = String.format("%d월 %d일 %s\n", month, i, strDay);
            boolean hasHoliday = HolidayType.checkedHoliday(output);

            String holidayStaff = getHolidayStaffsName(holidayCount);
            String weekdayStaff = getWeekDayStaffsName(weekDayCount);


            if (hasHoliday) {
                System.out.printf("%d월 %d일 %s(휴일) %s\n", month, i, strDay, holidayStaff);
                holidayCount++;
            }
            if (strDay.equals("토") || strDay.equals("일") && !hasHoliday) { // 토, 일 인데 휴일이 아니거나
                System.out.printf("%d월 %d일 %s %s\n", month, i, strDay, holidayStaff);
                holidayCount++;
            }
            if (!strDay.equals("토") && !strDay.equals("일") && !hasHoliday) {
                System.out.printf("%d월 %d일 %s %s\n", month, i, strDay, weekdayStaff);
                weekDayCount++;
            }


        }

    }

    public String getWeekDayStaffsName(int day) {
        List<String> staffs = weekday.getWeekDayStaffs();

        return staffs.get(day % staffs.size());

    }

    public String getHolidayStaffsName(int day) {
        List<String> staffs = holiday.getHolidayStaffs();

        return staffs.get(day % staffs.size());

    }

    private String getWeekTypeStrDay(int nextDay) {
        int day = WeekType.checkedWeekInt(strDay);
        return WeekType.checkedWeek(day + nextDay - 1);
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
