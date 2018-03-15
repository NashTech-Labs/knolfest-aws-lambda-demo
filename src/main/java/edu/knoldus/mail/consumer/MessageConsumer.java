package edu.knoldus.mail.consumer;

import edu.knoldus.mail.services.MessageService;


public class MessageConsumer implements Consumer{

    private MessageService service;

    public MessageConsumer(MessageService messageService){
        this.service=messageService;
    }

    public void processMessages(String message, String recipient){
        this.service.sendMessage(message, recipient);
    }

}
