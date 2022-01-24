package br.com.mdfilipiaki.school.domain.student.student;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// VALUE OBJECT

public class Cpf {

    private String code;

    private static final Pattern VALID_CPF_REGEX = Pattern.compile(
            "^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$"
    );

    public Cpf(String code) {
        if(code != null && validate(code)) {
            this.code = code;
        } else {
            throw new IllegalArgumentException("CPF NOT VALIDATED");
        }
    }

    private static boolean validate(final String code) {
        Matcher matcher = VALID_CPF_REGEX.matcher(code);
        return matcher.find();
    }

    public String getCode() {
        return code;
    }
}
