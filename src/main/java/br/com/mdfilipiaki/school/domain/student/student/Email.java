package br.com.mdfilipiaki.school.domain.student.student;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// VALUE OBJECT

public class Email {

    private String address;

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE
    );

    public Email(final String address) {
        if (address != null && validate(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("EMAIL NOT VALIDATED");
        }
    }

    private static boolean validate (final String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public String getAddress() {
        return address;
    }
}
