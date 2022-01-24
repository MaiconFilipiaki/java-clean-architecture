package br.com.mdfilipiaki.school.domain.student.student;

import java.io.Serial;

public class StudentNotFound extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public StudentNotFound(Cpf cpf) {
        super("Student not found with cpf: " + cpf.getCode());
    }

}
