package oncall.constants;

public enum HolidayType {

    HOLIDAY11("1월 1일"),
    HOLIDAY31("3월 1일"),
    HOLIDAY55("5월 5일"),
    HOLIDAY66("6월 6일"),
    HOLIDAY815("8월 15일"),
    HOLIDAY103("10월 3일"),
    HOLIDAY109("10월 9일"),
    HOLIDAY1225("12월 25일");


    private final String holiday;

    HolidayType(String holiday) {
        this.holiday = holiday;
    }

    public static boolean checkedHoliday(String calendar) {
        HolidayType[] holidays = HolidayType.values();
        for(HolidayType holidayType : holidays) {
            if(calendar.contains(holidayType.holiday)) {
                return true;
            }
        }
        return false;
    }

    public String getHoliday() {
        return holiday;
    }

    // 1-1
    // 3-1
    // 5-5
    // 6-6
    // 8-15
    // 10-3
    // 10-9
    // 12-25
}
