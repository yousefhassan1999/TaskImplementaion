package ParserPackage;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    private Map<String, Month> mapper = new HashMap<>();

    public Parser() {
        mapper.put("january", Month.JANUARY);
        mapper.put("february", Month.FEBRUARY);
        mapper.put("march", Month.MARCH);
        mapper.put("april", Month.APRIL);
        mapper.put("may", Month.MAY);
        mapper.put("june", Month.JUNE);
        mapper.put("july", Month.JULY);
        mapper.put("august", Month.AUGUST);
        mapper.put("september", Month.SEPTEMBER);
        mapper.put("october", Month.OCTOBER);
        mapper.put("november", Month.NOVEMBER);
        mapper.put("december", Month.DECEMBER);
    }

    public LocalDate DateTimeFormatterParser(String date) {
        String[] splitter = date.split(" ");
        return LocalDate.of(getYear(splitter[4]), getMonth(splitter[3]), getDay(splitter[1]));
    }

    private int getDay(String s) {
        return Integer.parseInt(s.substring(0, s.length() - 2));
    }

    private Month getMonth(String s) {
        return mapper.get(s.toLowerCase());
    }

    private int getYear(String s) {
        return Integer.parseInt(s);
    }
}
