package hello;

import school.data.Course;
import school.data.Student;
import school.data.Teacher;
import school.util.Utils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    @Test
    public void getTeachers() // testing if student can return all teachers it has
    {
        Teacher teacher1 = new Teacher("Moe", "Hp", Utils.dateToTypeZoneDateTime("2000", "12","12","03","04"), 23);
        Teacher teacher2 = new Teacher("Jose", "Hp", Utils.dateToTypeZoneDateTime("2000", "12","12","03","04"), 23);

        List<String> addedTeachers = Arrays.asList(teacher1.getFullName(), teacher2.getFullName());

        Course course1 = new Course("OOP", 5, Utils.dateToTypeZoneDateTime("2000", "12","12","03","04"), Utils.dateToTypeZoneDateTime("2000", "12","12","03","04"), teacher1);
        Course course2 = new Course("OOP", 5, Utils.dateToTypeZoneDateTime("2000", "12","12","03","04"), Utils.dateToTypeZoneDateTime("2000", "12","12","03","04"), teacher2);
        course1.setTeacher(teacher1);
        course2.setTeacher(teacher2);

        Student student = new Student("Juss", "Soe", Utils.dateToTypeZoneDateTime("2000", "12","12","03","04"), 15);
        student.setCourses(Arrays.asList(course1, course2));

        assertEquals(addedTeachers, student.getAllTeacherNames());
    }
}
