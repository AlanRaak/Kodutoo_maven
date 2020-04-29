package school.data;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class PersonImpl implements PersonInterface {

    String firstName;
    String lastname;
    String fullName;
    ZonedDateTime dateOfBirth;
    int age;

    public PersonImpl(String firstName, String lastname, ZonedDateTime dateOfBirth, int age) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.fullName = firstName + " " + lastname;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public String getFullName() {
        return fullName;
    }

    public ZonedDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public Long getAge() {
        return ChronoUnit.YEARS.between(this.dateOfBirth, ZonedDateTime.now());
    }

    public void sayHello() {

    }
}
