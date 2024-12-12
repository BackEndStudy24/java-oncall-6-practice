package oncall.model;

import oncall.constants.WorkingType;

public class Staff {

    private String name;
    private WorkingType weekType;

    public Staff(String name, WorkingType weekType) {
        this.name = name;
        this.weekType = weekType;
    }

    public String getName() {
        return name;
    }

    public WorkingType getWeekType() {
        return weekType;
    }
}
