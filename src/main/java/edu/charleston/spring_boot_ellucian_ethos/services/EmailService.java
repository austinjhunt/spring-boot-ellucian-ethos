package edu.charleston.spring_boot_ellucian_ethos.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

    private final String smtpHost;
    private final int smtpPort;
    private final String smtpUsername;
    private final String smtpPassword;

    public EmailService(String smtpHost, int smtpPort, String smtpUsername, String smtpPassword) {
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
        this.smtpUsername = smtpUsername;
        this.smtpPassword = smtpPassword;
    }

    private Session createSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", String.valueOf(smtpPort));

        return Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(smtpUsername, smtpPassword);
            }
        });
    }

    public boolean sendSync(String from, String to, String subject, String body, boolean isHtml) {
        try {
            Session session = createSession();
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);

            if (isHtml) {
                message.setContent(body, "text/html");
            } else {
                message.setText(body);
            }

            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void sendAsync(String from, String to, String subject, String body, boolean isHtml) {
        new Thread(() -> sendSync(from, to, subject, body, isHtml)).start();
    }

    public String addTimestampToSubject(String subject) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        return subject + " - " + now.format(formatter);
    }

    // Example usage:
    public static void main(String[] args) {
        EmailService emailService = new EmailService("smtp.gmail.com", 587, "your_email@gmail.com", "your_password");

        String from = "your_email@gmail.com";
        String to = "recipient@example.com";
        String subject = "Test Email";
        String body = "This is a test email.";
        boolean isHtml = false;

        boolean sent = emailService.sendSync(from, to, subject, body, isHtml);
        if (sent) {
            System.out.println("Email sent successfully (sync).");
        } else {
            System.out.println("Failed to send email (sync).");
        }

        emailService.sendAsync(from, to, "Async Test", "This is an async test", false);
        System.out.println("Email send started async");
    }
}