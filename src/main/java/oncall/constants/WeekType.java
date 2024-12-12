package oncall.constants;

public enum WeekType {

    MONDAY("월",0),
    TUESDAY("화",1),
    WEDNESDAY("수",2),
    THURSDAY("목",3),
    FRIDAY("금",4),
    SATURDAY("토",5),
    SUNDAY("일",6);

    private final String strDay;
    private final int day;

    WeekType(String strDay, int day) {
        this.strDay = strDay;
        this.day = day;
    }

    public static int checkedWeekInt(String strDay) {
        WeekType[] weekTypes = WeekType.values();
        for(WeekType weekType : weekTypes) {
            if(weekType.strDay.equals(strDay)) {
                return weekType.day;
            }
        }
        return -1;
    }

    public static String checkedWeek(int day) {
        WeekType[] weekTypes = WeekType.values();
        for(WeekType weekType : weekTypes)  {
            if(weekType.day == (day % 7)) { // 0 -> 월
                return weekType.strDay;
            }
        }
        return null;
    }

    public String getStrDay() {
        return strDay;
    }

    public int getDay() {
        return day;
    }
}
