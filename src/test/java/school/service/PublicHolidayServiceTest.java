package school.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PublicHolidayServiceTest {

    @Test
    public void getPublicHolidaysTest() {
        PublicHolidayService publicHolidayService = new PublicHolidayService();
        assertEquals(school.util.Utils.dateToTypeZoneDateTime("2015-05-24"), publicHolidayService.getPublicHolidays(2015).get(5));
    }
}
