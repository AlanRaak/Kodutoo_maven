package school.data;

import school.service.PublicHolidayService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.ZonedDateTime;

import static org.junit.Assert.assertEquals;

public class CourseTest {

    @Mock
    private PublicHolidayService publicHolidayServiceMock;

    @Mock
    private school.util.Utils utils;

    @InjectMocks
    private Course course;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getLengthTest() {
        ZonedDateTime start = school.util.Utils.dateToTypeZoneDateTime("2020-01-01");
        ZonedDateTime end = school.util.Utils.dateToTypeZoneDateTime("2020-12-27");

        course.setStartDate(start);
        course.setEndDate(end);

        assertEquals(249, course.getNetLength());
    }
}
