package oncall.model;

import oncall.constants.WeekType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StaffWeekday {

    private List<Staff> weekDayStaffs = new ArrayList<>();


    public void inputWeekDayStaffs(List<String> staffs) {
        for (String staff : staffs) {
            weekDayStaffs.add(new Staff(staff, WeekType.WEEKDAY));
        }
    }

    public List<String> getWeekDayStaffs() {
        return weekDayStaffs
                .stream()
                .map(Staff::getName)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
