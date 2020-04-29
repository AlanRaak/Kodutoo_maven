package school.data;

import java.time.ZonedDateTime;

public interface PersonInterface {

    String getFirstName();

    String getLastName();

    String getFullName();

    ZonedDateTime getDateOfBirth();

    Long getAge();

    void sayHello();
}
