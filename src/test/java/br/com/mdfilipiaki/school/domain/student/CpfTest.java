package br.com.mdfilipiaki.school.domain.student;

import br.com.mdfilipiaki.school.domain.student.student.Cpf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfTest {

    @Test
    void mustNotCreateCpfBecauseNotValid() {
        assertThrows(IllegalArgumentException.class, () -> new Cpf(null));
        assertThrows(IllegalArgumentException.class, () -> new Cpf(""));
        assertThrows(IllegalArgumentException.class, () -> new Cpf("123123123132"));
    }

    @Test
    void mustCreateCpfValid() {
        String cpfTest = "034.079.800-94";

        Cpf cpf = new Cpf(cpfTest);

        assertEquals(cpfTest, cpf.getCode());
    }

}