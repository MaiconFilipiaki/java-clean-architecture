package br.com.mdfilipiaki.school.domain.student.indication;

import br.com.mdfilipiaki.school.domain.student.student.Student;

import java.time.LocalDateTime;

public class Indication {

    private Student indicated;
    private Student pointer;
    private LocalDateTime dateIndication;

    public Indication(Student indicated, Student pointer) {
        this.indicated = indicated;
        this.pointer = pointer;
        this.dateIndication = LocalDateTime.now();
    }

    public Student getIndicated() {
        return indicated;
    }

    public Student getPointer() {
        return pointer;
    }

    public LocalDateTime getDateIndication() {
        return dateIndication;
    }
}
