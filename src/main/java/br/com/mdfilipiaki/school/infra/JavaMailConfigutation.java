package br.com.mdfilipiaki.school.infra;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;
import java.util.regex.Pattern;

public class JavaMailConfigutation {

    private static final String username = System.getenv("USERNAME_MAIL");
    private static final String password = System.getenv("USERNAME_PASSWORD");
    private static final String host = System.getenv("USERNAME_HOST");
    private static final int port = Integer.parseInt(System.getenv("USERNAME_PORT"));

    private final Properties properties;

    public JavaMailConfigutation() {
        this.properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.ssl.trust", host);
    }

    public void sendMail(String toEmail, String subject, String msg) {
        try {
            Session session = Session.getInstance(this.properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("teste@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);
            Transport.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Error send email: " + e.getMessage());
        }
    }

}
