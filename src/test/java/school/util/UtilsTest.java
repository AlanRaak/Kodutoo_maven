package school.util;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class UtilsTest {
    @Test
    public void getNonWeekendHolidaysEdgesIncludedTest() throws IOException { // checks if edges are included(start and end date)
        int days = Utils.getNonWeekendHolidays(Utils.dateToTypeZoneDateTime("2020-01-01"), Utils.dateToTypeZoneDateTime("2020-02-24"));
        assertEquals(2, days);
    }

    @Test
    public void getNonWeekendHolidaysWeekendsExcludedTest() throws IOException {
        int days = Utils.getNonWeekendHolidays(Utils.dateToTypeZoneDateTime("2020-02-20"), Utils.dateToTypeZoneDateTime("2020-04-14"));
        assertEquals(2, days);
    }
}
