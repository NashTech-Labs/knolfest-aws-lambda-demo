package edu.knoldus;

import com.amazonaws.services.lambda.runtime.Context;
import edu.knoldus.model.Request;
import edu.knoldus.model.Response;
import edu.knoldus.testutils.TestContext;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class SendEmailTest {

    private static Request input;

    @Before
    public void createInput() {
        input = new Request();
        input.setEmail("knolfest@knoldus.com");
        input.setMessage("Hello Knolfest !!");
    }

    private Context createContext() {
        TestContext ctx = new TestContext();
        ctx.setFunctionName("SendMailLambda");
        return ctx;
    }

    @Test
    public void testHandleRequest() {
        SendEmail handler = new SendEmail();
        Context ctx = createContext();
        Response response = handler.handleRequest(input, ctx);
        assertNotNull(response);
        assertTrue(response.getMessage().contains(input.getEmail()));
    }

}