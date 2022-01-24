package br.com.mdfilipiaki.school.domain.student.student;

public class Phone {

    private String ddd;
    private String number;

    public Phone(final String ddd, final String number) {
        if (ddd != null && number != null && ddd.length() == 2 && number.length() == 9) {
            this.ddd = ddd;
            this.number = number;
        } else {
            throw new IllegalArgumentException("Phone not valid");
        }
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumber() {
        return number;
    }
}
