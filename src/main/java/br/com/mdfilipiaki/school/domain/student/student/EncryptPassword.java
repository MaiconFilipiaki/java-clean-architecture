package br.com.mdfilipiaki.school.domain.student.student;

public interface EncryptPassword {

    String encryptPassword(String password);

    boolean validatedPasswordEncrypt(String passwordEncrypt, String password);
}
