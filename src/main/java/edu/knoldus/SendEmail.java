package edu.knoldus;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.knoldus.mail.consumer.Consumer;
import edu.knoldus.mail.injector.EmailServiceInjector;
import edu.knoldus.mail.injector.MessageServiceInjector;
import edu.knoldus.model.Request;
import edu.knoldus.model.Response;

public class SendEmail implements RequestHandler<Request, Response> {

    public Response handleRequest(Request request, Context context) {
        MessageServiceInjector injector;
        Consumer consumer;
        String email = request.getEmail();
        String message = request.getMessage();
        injector = new EmailServiceInjector();
        consumer = injector.getConsumer();
        consumer.processMessages(message, email);
        return new Response("Email Sent on " + request.getEmail());
    }
}