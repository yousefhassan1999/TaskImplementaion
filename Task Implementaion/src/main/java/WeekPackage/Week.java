package WeekPackage;

import java.time.LocalDate;

public class Week {
    private int number;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;

    public Week(int number, String type, LocalDate startDate, LocalDate endDate) {
        this.number = number;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Week" +
                " #" + number +
                " - " + type +
                " - from " + startDate.getDayOfMonth() + " " + startDate.getMonth() +
                " to " + endDate.getDayOfMonth() + " " + endDate.getMonth();
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
