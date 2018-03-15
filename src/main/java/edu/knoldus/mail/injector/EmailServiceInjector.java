package edu.knoldus.mail.injector;

import edu.knoldus.mail.consumer.Consumer;
import edu.knoldus.mail.consumer.MessageConsumer;
import edu.knoldus.mail.services.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector {

    public Consumer getConsumer() {
        return new MessageConsumer(new EmailServiceImpl());
    }

}
