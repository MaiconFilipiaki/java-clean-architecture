package br.com.mdfilipiaki.school.application.student.enroll;

import br.com.mdfilipiaki.school.domain.student.student.Cpf;
import br.com.mdfilipiaki.school.domain.student.student.Student;
import br.com.mdfilipiaki.school.infra.student.RepositoryStudentMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnrollStudentTest {

    @Test
    void studentMustBePersist() {
        RepositoryStudentMemory repositoryStudentMemory = new RepositoryStudentMemory();
        EnrollStudent useCase = new EnrollStudent(repositoryStudentMemory);
        String nameTest = "Fulao";
        String CPFTest = "123.123.123-00";
        String emailTest = "fulano@gmail.com";

        EnrollStudentDto data = new EnrollStudentDto(nameTest, CPFTest, emailTest);
        useCase.exec(data);

        Student student = repositoryStudentMemory.findByCpf(new Cpf(CPFTest));
        assertEquals(nameTest, student.getName());
        assertEquals(CPFTest, student.getCpf());
        assertEquals(emailTest, student.getEmail());
    }
}