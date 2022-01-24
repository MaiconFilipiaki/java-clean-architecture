package br.com.mdfilipiaki.school.domain.student.student;

public class FactoryStudent {

    private Student student;

    public FactoryStudent withNameCpfEmail(String name, String cpf, String email) {
        this.student = new Student(new Cpf(cpf), name, new Email(email));
        return this;
    }

    public FactoryStudent withPhone(String ddd, String number) {
        this.student.addPhone(new Phone(ddd, number));
        return this;
    }

    public Student create() {
        return this.student;
    }

    /*
        return this will enable initiate calling method in sequence
        DEMO:
        FactoryStudent factory = new FactoryStudent();
        Student student = factory.withNameCpfEmail("", "", "").withPhone("", "").withPhone("", "").create();
                                                               this
     */

}
