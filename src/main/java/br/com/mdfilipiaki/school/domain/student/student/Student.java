package br.com.mdfilipiaki.school.domain.student.student;

// Entity

import java.util.ArrayList;
import java.util.List;

public class Student {

    private Cpf cpf;
    private String name;
    private Email email;
    private final List<Phone> phones = new ArrayList<>();
    private String password;

    public Student(Cpf cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public void addPhone(final Phone phone) {
        this.phones.add(phone);
    }

    public String getCpf() {
        return cpf.getCode();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email.getAddress();
    }

    public List<Phone> getPhones() {
        return phones;
    }
}
