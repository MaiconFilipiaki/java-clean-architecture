package br.com.mdfilipiaki.school.infra.student;

import br.com.mdfilipiaki.school.domain.student.student.Cpf;
import br.com.mdfilipiaki.school.domain.student.student.RepositoryStudent;
import br.com.mdfilipiaki.school.domain.student.student.Student;
import br.com.mdfilipiaki.school.domain.student.student.StudentNotFound;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryStudentMemory implements RepositoryStudent {

    private final List<Student> enroll = new ArrayList<>();

    @Override
    public void enroll(Student student) {
        this.enroll.add(student);
    }

    @Override
    public Student findByCpf(Cpf cpf) {
        return this.enroll.stream()
                .filter(i -> i.getCpf().equals(cpf.getCode()))
                .findFirst()
                .orElseThrow(() -> new StudentNotFound(cpf));
    }

    @Override
    public List<Student> getAllStudentsEnroll() {
        return this.enroll;
    }
}
