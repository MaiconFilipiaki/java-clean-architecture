package br.com.mdfilipiaki.school.domain.student;

import br.com.mdfilipiaki.school.domain.student.student.Email;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    @Test
    void mustNotCreateEmailsWithAddressInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email("emailInvalid"));
    }

    @Test
    void mustCreateEmailValid() {
        String emailTest = "teste@gmail.com";

        Email email = new Email(emailTest);

        assertEquals(email.getAddress(), emailTest);
    }


}
