package br.com.mdfilipiaki.school.application.indication;

import br.com.mdfilipiaki.school.domain.student.student.Student;

public interface SendEmailIndication {

    void sendTo(Student indicated);

}
