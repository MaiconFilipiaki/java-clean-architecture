package br.com.mdfilipiaki.school.domain.student.student;

import java.sql.SQLException;
import java.util.List;

/*
    Interface will work as contract with external world
 */

public interface RepositoryStudent {

    void enroll(Student student);

    Student findByCpf(Cpf cpf) throws SQLException;

    List<Student> getAllStudentsEnroll();

}
