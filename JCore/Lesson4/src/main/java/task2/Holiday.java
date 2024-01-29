package task2;

import java.time.MonthDay;
import java.util.Set;

public class Holiday {
    MonthDay monthDay;
    Set<Sex> sex;

    public Holiday(MonthDay monthDay, Set<Sex> sex) {
        this.monthDay = monthDay;
        this.sex = sex;
    }

    public void setMonthDay(MonthDay monthDay) {
        this.monthDay = monthDay;
    }

    public void addSex(Sex sex) {
        this.sex.add(sex);
    }
}
