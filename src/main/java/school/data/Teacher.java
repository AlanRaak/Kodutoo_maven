package school.data;

import java.time.ZonedDateTime;

public class Teacher extends PersonImpl {

    public Teacher(String firstName, String lastname, ZonedDateTime dateOfBirth, int age) {
        super(firstName, lastname, dateOfBirth, age);
    }

    @Override
    public void sayHello() {

    }
}
