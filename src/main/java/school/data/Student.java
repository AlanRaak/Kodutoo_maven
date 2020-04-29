package school.data;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Student extends PersonImpl {

    List<Course> courses;

    public Student(String firstName, String lastname, ZonedDateTime dateOfBirth, int age, List<Course> courses) {
        super(firstName, lastname, dateOfBirth, age);
        this.courses = courses;
    }

    public Student(String firstName, String lastname, ZonedDateTime dateOfBirth, int age) {
        super(firstName, lastname, dateOfBirth, age);
    }

    @Override
    public void sayHello() {

    }

    public List<String> getAllTeacherNames() {
        List<String> teachers = new ArrayList<>();

        for (Course course : courses) {
            teachers.add(course.getTeacher().getFullName());
        }

        return teachers;
        /*return courses.stream()
                .map(Course::getName)
                .collect(Collectors.toList());*/
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(List<Course> course) {
        this.courses.add((Course) course);
    }
}
