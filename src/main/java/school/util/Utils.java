package school.util;

import school.data.Student;
import school.service.PublicHolidayService;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Utils {

    public static void printStudentsFullName(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.getFullName());
        }
    }

    public static ZonedDateTime dateToTypeZoneDateTime(String year, String numericMonth, String numericDay, String hour, String minute) {
        //ZonedDateTime zonedDateTime = ZonedDateTime.parse("2018-09-16T08:00:00+00:00[Europe/London]");
        return ZonedDateTime.parse(String.format("%s-%s-%sT%s:%s:00+00:00[UTC]", year, numericMonth, numericDay, hour, minute));
    }

    public static ZonedDateTime dateToTypeZoneDateTime(String date_yyyy_MM_dd) {
        return ZonedDateTime.parse(String.format("%sT00:00:00+00:00[UTC]", date_yyyy_MM_dd));
    }

    public static String getDateString(ZonedDateTime date) {
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static int getNonWeekendHolidays(ZonedDateTime startingDate, ZonedDateTime endingDate) throws IOException {
        PublicHolidayService holidayService = new PublicHolidayService();
        int holidays = 0;

        for (ZonedDateTime date : holidayService.getPublicHolidays(startingDate.getYear())) {
            if (date.toLocalDate().isAfter(startingDate.toLocalDate().minusDays(1)) // minus to include starting date
                    && ((date.toLocalDate()).isBefore(endingDate.toLocalDate().plusDays(1))) // plus to include ending date
                    && ((date.getDayOfWeek().getValue()) != 6) // excluding sunday and saturday
                    && ((date.getDayOfWeek().getValue()) != 7)) {
                holidays++;
            }
        }
        return holidays;
    }
}
