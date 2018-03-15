package edu.knoldus;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import edu.knoldus.model.Request;

public class SendEmail implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {


    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
        LambdaLogger logger = context.getLogger();
        String body = request.getBody();
        Gson gson = new Gson();
        Request myRequest = gson.fromJson(body, Request.class);

        logger.log(myRequest.getEmail() + " : " + myRequest.getMessage());

        //Todo: Write your logic here


        APIGatewayProxyResponseEvent respone = new APIGatewayProxyResponseEvent();
        respone.withBody("{\"message\":\"sent\"}");

        return respone;
    }

}