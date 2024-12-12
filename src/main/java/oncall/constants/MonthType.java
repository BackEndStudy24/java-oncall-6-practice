package oncall.constants;

public enum MonthType {


    MONTH_1(1, 31),
    MONTH_2(2, 28),
    MONTH_3(3, 31),
    MONTH_4(4, 30),
    MONTH_5(5, 31),
    MONTH_6(6, 30),
    MONTH_7(7, 31),
    MONTH_8(8, 31),
    MONTH_9(9, 30),
    MONTH_10(10, 31),
    MONTH_11(11, 30),
    MONTH_12(12, 31);


    private final int month;
    private final int day;

    MonthType(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static MonthType checkedDay(int month) {
        MonthType[] monthTypes = MonthType.values();
        for(int i = 0; i <monthTypes.length; i++ ) {
            if(monthTypes[i].day == month) {
                return monthTypes[i];
            }
        }
        return null;
    }


}
