package oncall.constants;

public enum WorkingType {

    WEEKDAY(0),
    HOLIDAY(1);

    private final int type;

    WorkingType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
