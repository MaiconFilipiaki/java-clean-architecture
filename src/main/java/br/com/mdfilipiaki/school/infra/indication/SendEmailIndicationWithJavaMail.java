package br.com.mdfilipiaki.school.infra.indication;

import br.com.mdfilipiaki.school.application.indication.SendEmailIndication;
import br.com.mdfilipiaki.school.domain.student.student.Student;
import br.com.mdfilipiaki.school.infra.JavaMailConfigutation;

public class SendEmailIndicationWithJavaMail implements SendEmailIndication {
    @Override
    public void sendTo(Student indicated) {
        new JavaMailConfigutation().sendMail(indicated.getEmail(), "Welcome", "Welcome");
    }
}
