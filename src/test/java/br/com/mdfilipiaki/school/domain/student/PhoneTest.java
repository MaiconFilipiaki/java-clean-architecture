package br.com.mdfilipiaki.school.domain.student;

import br.com.mdfilipiaki.school.domain.student.student.Phone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @Test
    void mustNotCreatePhoneBecauseNotValidNumber() {

        String dddLarger = "222";
        String dddSmaller = "1";
        String numberLarger = "1234567891";
        String numberSmaller = "12345678";

        assertThrows(IllegalArgumentException.class, () -> new Phone(null, null));
        assertThrows(IllegalArgumentException.class, () -> new Phone("", ""));
        assertThrows(IllegalArgumentException.class, () -> new Phone(dddLarger, numberLarger));
        assertThrows(IllegalArgumentException.class, () -> new Phone(dddSmaller, numberSmaller));

    }

    @Test
    void mustCreatePhone() {

        String ddd = "51";
        String number = "123456789";

        Phone phone = new Phone(ddd, number);

        assertEquals(ddd, phone.getDdd());
        assertEquals(number, phone.getNumber());
    }

}