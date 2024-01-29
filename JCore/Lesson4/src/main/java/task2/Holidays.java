package task2;

import java.time.MonthDay;
import java.util.Set;

import static task2.Sex.FEMALE;
import static task2.Sex.MALE;


public enum Holidays {
    NEW_YEAR,
    MARCH_8,
    RKKA_DAY;

    public static Holiday getHoliday(Holidays holidays) {
        switch (holidays) {
            case MARCH_8 -> {
                return new Holiday(MonthDay.of(3, 8), Set.of(FEMALE));
            }
            case NEW_YEAR -> {
                return new Holiday(MonthDay.of(12,31), Set.of(FEMALE, MALE));
            }
            case RKKA_DAY -> {
                return new Holiday(MonthDay.of(2, 23), Set.of(MALE));
            }
        }
        return null;
    }
}
