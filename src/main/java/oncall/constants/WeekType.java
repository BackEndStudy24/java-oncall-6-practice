package oncall.constants;

public enum WeekType {

    WEEKDAY(0),
    HOLIDAY(1);

    private final int type;

    WeekType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
