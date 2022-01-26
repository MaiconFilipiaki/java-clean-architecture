package br.com.mdfilipiaki.school.application.student.enroll;

import br.com.mdfilipiaki.school.domain.student.student.Cpf;
import br.com.mdfilipiaki.school.domain.student.student.FactoryStudent;
import br.com.mdfilipiaki.school.domain.student.student.Student;

public class EnrollStudentDto {

    private String name;
    private String cpf;
    private String email;

    public EnrollStudentDto(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public Student createStudent() {
        return new FactoryStudent().withNameCpfEmail(this.name, this.cpf, this.email).create();
    }
}
