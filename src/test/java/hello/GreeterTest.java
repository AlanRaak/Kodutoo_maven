package hello;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class GreeterTest
{
    @Mock // Küsimus 2: Kas see Mock on vajalik? Test kasutab ainult greeterMock objecti ju.
    private Counter counter;

    @InjectMocks // Küsimus 1: Kas see siin tekitab Greeter objekti, mis edaspidi kasutab Counter klassi "mocki"(koopiat) ?
    private Greeter greeter; // Küsimus 1: Ehk InjectMocks loob objetci, mis automaatselt hakkab kasutama edaspidi loodud mocke, mida Greeter klass funksioon sayHello() kasutab.

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveTest()
    {
        // when(counterMock.nameLength("Jaanus")).thenReturn(6); // Küsimus 5: Seda peaksin kasutama siis, kui näiteks Counter suhtleb andmebaasiga ja testis ma ei taha, et ta seda teeks?
        assertThat(greeter.sayHello("Jaanus"), containsString("Tere")); // Küsimus 6: Kas see osa siin nüüd ei kasuta või ei tekita Counter klassi objekti greeterMock.sayHello("Jaanus") sees?

    }
}