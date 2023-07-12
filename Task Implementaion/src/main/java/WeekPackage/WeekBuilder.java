package WeekPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WeekBuilder {
    private List<Week> weeks = new ArrayList<>();
    private LocalDate planStartDateLocalDate;
    private LocalDate raceDate;
    private int weekNum = 1;

    public WeekBuilder(LocalDate planStartDateLocalDate,LocalDate raceDate ) {
        this.planStartDateLocalDate = planStartDateLocalDate;
        this.raceDate = raceDate;
    }

    public void addWeek(String type) {
        this.weeks.add(new Week(weekNum++, type, planStartDateLocalDate, planStartDateLocalDate.plusDays(6)));
        planStartDateLocalDate = planStartDateLocalDate.plusDays(7);
    }

    public void addAllWeek(String[] types) {
        for(String type: types)
            addWeek(type);
    }

    public List<Week> getWeeks() {
        return weeks;
    }

}
