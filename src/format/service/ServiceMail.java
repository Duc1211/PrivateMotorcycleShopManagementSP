package format.service;


import model.MailModel;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class ServiceMail {

    public MailModel sendMain(String toEmail, String code) {
        MailModel ms = new MailModel(false, "");
        String from = "nhomqlyxe@gmail.com";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");


        String username = "nhomqlyxe@gmail.com";
        String password = "duchuyhoangthinh";    //  Your email password here

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            javax.mail.Message  message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Verify Code");
            message.setText(code);
            Transport.send(message);
            ms.setSuccess(true);
        } catch (MessagingException e) {
            if (e.getMessage().equals("Invalid Addresses")) {
                ms.setMessage("Invalid email");
            } else {
                ms.setMessage("Error");
            }
        }
        return ms;
    }
}
