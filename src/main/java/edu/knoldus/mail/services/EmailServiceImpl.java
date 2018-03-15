package edu.knoldus.mail.services;

import edu.knoldus.utils.ConfigReader;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailServiceImpl implements MessageService {

    private Properties properties = new Properties();
    private Session session = Session.getDefaultInstance(properties);

    public EmailServiceImpl() {
        ConfigReader configReader = ConfigReader.getConfigReader("knolfest-demo");
        properties.put("mail.smtp.port", configReader.getPort());
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.host", configReader.getHostName());
        properties.setProperty("mail.user", configReader.getSenderEmail());
        properties.setProperty("mail.password", configReader.getSenderEmailPassword());
        properties.setProperty("mail.smtp.auth", "true");
    }

    public Boolean sendMessage(String message, String recipient) {
        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.addRecipients(Message.RecipientType.TO, recipient);
            mimeMessage.setSubject("Message From AWS LAMBDA");
            mimeMessage.setHeader("Content-Type", "text/plain;");
            mimeMessage.setContent(message, "text/html");
            Transport transport = session.getTransport("smtp");
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}