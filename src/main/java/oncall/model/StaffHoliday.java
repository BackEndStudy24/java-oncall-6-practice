package oncall.model;

import oncall.constants.WorkingType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StaffHoliday {

    private List<Staff> holidayStaffs = new ArrayList<>();

    public void inputHolidayStaffs(List<String> staffs) {
        for (String staff : staffs) {
            holidayStaffs.add(new Staff(staff, WorkingType.HOLIDAY));
        }
    }

    public List<String> getHolidayStaffs() {
        return holidayStaffs
                .stream()
                .map(Staff::getName)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
