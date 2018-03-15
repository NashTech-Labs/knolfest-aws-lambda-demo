package edu.knoldus.mail.consumer;

import edu.knoldus.mail.injector.MessageServiceInjector;
import edu.knoldus.mail.services.MessageService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MessageConsumerTest {

    private MessageServiceInjector messageServiceInjector;

    @Before
    public void beforeTest() {
        messageServiceInjector = () -> new MessageConsumer((message, recipient) -> true);
    }

    @Test
    public void testProcessMessage() {
        Consumer consumer = messageServiceInjector.getConsumer();
        consumer.processMessages("Test", "knolfest@knoldus.com");
    }

}
