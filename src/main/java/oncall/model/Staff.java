package oncall.model;

import oncall.constants.WeekType;

public class Staff {

    private String name;
    private WeekType weekType;

    public Staff(String name, WeekType weekType) {
        this.name = name;
        this.weekType = weekType;
    }

}
