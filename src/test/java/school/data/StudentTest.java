package school.data;

import school.util.Utils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    @Test
    public void getAllTeacherNamesTest() {
        String name1 = "Moe";
        String name2 = "Ye";
        String name3 = "Maali";

        Teacher teacher1 = new Teacher(name1, name1, Utils.dateToTypeZoneDateTime("2000", "12", "12", "03", "04"), 23);
        Teacher teacher2 = new Teacher(name2, name2, Utils.dateToTypeZoneDateTime("2000", "12", "12", "03", "04"), 40);
        Teacher teacher3 = new Teacher(name3, name3, Utils.dateToTypeZoneDateTime("2000-10-04"), 40);

        Course course1 = new Course("OOP", 5, Utils.dateToTypeZoneDateTime("2000", "12", "12", "03", "04"), Utils.dateToTypeZoneDateTime("2000", "12", "12", "03", "04"), teacher1);
        Course course2 = new Course("OOP", 5, Utils.dateToTypeZoneDateTime("2020-01-01"), Utils.dateToTypeZoneDateTime("2020-02-04"), teacher2);
        Course course3 = new Course("Kool", 5, Utils.dateToTypeZoneDateTime("2020-01-01"), Utils.dateToTypeZoneDateTime("2020-02-04"), teacher3);

        Student student = new Student("Juss", "Soe", Utils.dateToTypeZoneDateTime("2000", "12", "12", "03", "04"), 15, Arrays.asList(course1, course2, course3));
        //System.out.println(course2.getLength());

        List<String> teachers = student.getAllTeacherNames();

        assertEquals(name1 + " " + name1, teachers.get(0));
        assertEquals(name2 + " " + name2, teachers.get(1));
        assertEquals(name3 + " " + name3, teachers.get(2));
    }

    @Test
    public void getCoursesTest(){
        Teacher teacher1 = new Teacher("name1", "name1", Utils.dateToTypeZoneDateTime("2000", "12", "12", "03", "04"), 23);
        Teacher teacher2 = new Teacher("name2", "name2", Utils.dateToTypeZoneDateTime("2000", "12", "12", "03", "04"), 40);
        Teacher teacher3 = new Teacher("name3", "name3", Utils.dateToTypeZoneDateTime("2000-10-04"), 40);

        Course course1 = new Course("OOP", 5, Utils.dateToTypeZoneDateTime("2000", "12", "12", "03", "04"), Utils.dateToTypeZoneDateTime("2000", "12", "12", "03", "04"), teacher1);
        Course course2 = new Course("Uuring", 5, Utils.dateToTypeZoneDateTime("2020-01-01"), Utils.dateToTypeZoneDateTime("2020-02-04"), teacher2);
        Course course3 = new Course("Kool", 5, Utils.dateToTypeZoneDateTime("2020-01-01"), Utils.dateToTypeZoneDateTime("2020-02-04"), teacher3);

        Student student = new Student("Juss", "Soe", Utils.dateToTypeZoneDateTime("2000", "12", "12", "03", "04"), 15, Arrays.asList(course1, course2, course3));

        assertEquals(course1, student.getCourses().get(0));
        assertEquals(course2, student.getCourses().get(1));
        assertEquals(course3, student.getCourses().get(2));
    }

}
