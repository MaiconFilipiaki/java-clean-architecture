package br.com.mdfilipiaki.school.infra.student;

import br.com.mdfilipiaki.school.domain.student.student.EncryptPassword;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptPasswordWithMD5 implements EncryptPassword {
    @Override
    public String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error create encrypt");
        }
    }

    @Override
    public boolean validatedPasswordEncrypt(String passwordEncrypt, String password) {
        return passwordEncrypt.equals(encryptPassword(password));
    }
}
