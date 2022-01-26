package br.com.mdfilipiaki.school.application.student.enroll;

import br.com.mdfilipiaki.school.domain.student.student.RepositoryStudent;
import br.com.mdfilipiaki.school.domain.student.student.Student;

/**
 * representation use_cases of enroll student at classroom
 * pattern command
 */

public class EnrollStudent {

    private final RepositoryStudent repositoryStudent;

    public EnrollStudent(RepositoryStudent repositoryStudent) {
        this.repositoryStudent = repositoryStudent;
    }

    public void exec(EnrollStudentDto enrollStudentDto) {
        Student student = enrollStudentDto.createStudent();
        repositoryStudent.enroll(student);
    }

}
