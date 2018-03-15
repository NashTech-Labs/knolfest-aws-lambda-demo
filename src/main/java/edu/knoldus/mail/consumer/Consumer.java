package edu.knoldus.mail.consumer;

public interface Consumer {

    void processMessages(String message, String recipient);

}