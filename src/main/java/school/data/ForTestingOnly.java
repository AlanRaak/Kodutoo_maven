package school.data;

import school.service.PublicHolidayService;
import school.util.Utils;

import java.util.Arrays;
import java.util.List;

public class ForTestingOnly {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Moe", "Hp", Utils.dateToTypeZoneDateTime("2000", "12", "12", "03", "04"), 23);
        Teacher teacher2 = new Teacher("Ye", "iu", Utils.dateToTypeZoneDateTime("2000", "12", "12", "03", "04"), 40);
        Teacher teacher3 = new Teacher("Ye", "iu", Utils.dateToTypeZoneDateTime("2000-10-04"), 40);

        Course course1 = new Course("OOP", 5, Utils.dateToTypeZoneDateTime("2000", "12", "12", "03", "04"), Utils.dateToTypeZoneDateTime("2000", "12", "12", "03", "04"), teacher1);
        Course course2 = new Course("OOP", 5, Utils.dateToTypeZoneDateTime("2020-01-01"), Utils.dateToTypeZoneDateTime("2020-02-04"), teacher2);
        Student student = new Student("Juss", "Soe", Utils.dateToTypeZoneDateTime("2000", "12", "12", "03", "04"), 15);
        //System.out.println(course2.getLength());

        course1.setTeacher(teacher1);
        course2.setTeacher(teacher2);

        student.setCourses(Arrays.asList(course1, course2));
        List<String> teachies = student.getAllTeacherNames();
        System.out.println(teachies);

        //Utils.printStudentsFullName(Arrays.asList(student));
        PublicHolidayService holidays = new PublicHolidayService();
        System.out.println("Public holis 2020: " + holidays.getPublicHolidays(2020));
        System.out.println("Non weekend holidays" + school.util.Utils.getNonWeekendHolidays(school.util.Utils.dateToTypeZoneDateTime("2017-01-05"), school.util.Utils.dateToTypeZoneDateTime("2017-02-24")));
    }
}
