import ParserPackage.Parser;
import WeekPackage.Week;
import WeekPackage.WeekBuilder;
import WeekPackage.WeeksTypes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TrainingPlanGenerator {
    private static Parser parser = new Parser();
    private static WeekBuilder weekBuilder;
    private static long totalWeeks;

    public static void main(String[] args) throws Exception {
        String planStartDateString = "Sunday 6th of June 2021";
        String raceDateString = "Saturday 14th of August 2021";

        computeNumberOfWeeks(planStartDateString, raceDateString);
        generateTrainingPlan();
    }

    private static void computeNumberOfWeeks(String planStartDateString, String raceDateString) throws Exception {
        LocalDate planStartDate = parser.DateTimeFormatterParser(planStartDateString);
        LocalDate raceDate = parser.DateTimeFormatterParser(raceDateString);

        weekBuilder = new WeekBuilder(planStartDate, raceDate);

        totalWeeks = ChronoUnit.WEEKS.between(planStartDate, raceDate) + 1;

        while(planStartDate.plusDays(totalWeeks*7-1).compareTo(raceDate)  > 0)
            totalWeeks--;

        if (totalWeeks < 8)
            throw new Exception("Error: Total number of weeks is less than 8.");
    }

    public static void generateTrainingPlan() {
        weekBuilder.addAllWeek(new String[]{WeeksTypes.Test.label, WeeksTypes.Test.label});

        int caseState = 0;
        if (totalWeeks % 4 == 1) {
            weekBuilder.addWeek(WeeksTypes.Filler.label);
            caseState = 1;
        } else if (totalWeeks % 4 == 2) {
            weekBuilder.addAllWeek(new String[]{WeeksTypes.Build_2.label,WeeksTypes.Key.label});
            caseState = 2;
        } else if(totalWeeks % 4 == 3){
            weekBuilder.addAllWeek(new String[]{WeeksTypes.Build_1.label,WeeksTypes.Build_2.label,WeeksTypes.Key.label});
            caseState = 3;
        }
        int number = (int) ((totalWeeks - 4 - caseState) / 4);
        createMainBlockAndFinalWeeks(number);

        for (Week week : weekBuilder.getWeeks())
            System.out.println(week.toString());
    }

    private static void createMainBlockAndFinalWeeks(int numMainBlocks) {
        for (int i = 0; i < numMainBlocks; i++) {
            weekBuilder.addAllWeek(new String[]{WeeksTypes.Recovery.label, WeeksTypes.Build_1.label, WeeksTypes.Build_2.label, WeeksTypes.Key.label});
        }
        weekBuilder.addAllWeek(new String[]{WeeksTypes.Taper.label,WeeksTypes.Race.label});
    }


}
