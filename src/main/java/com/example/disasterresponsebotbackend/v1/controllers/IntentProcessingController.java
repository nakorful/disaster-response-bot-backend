package com.example.disasterresponsebotbackend.v1.controllers;

import com.example.disasterresponsebotbackend.v1.domains.webhook.request.WebhookRequest;
import com.example.disasterresponsebotbackend.v1.domains.webhook.response.FulfillmentMessage;
import com.example.disasterresponsebotbackend.v1.domains.webhook.response.FulfillmentMessageText;
import com.example.disasterresponsebotbackend.v1.domains.webhook.response.WebhookResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

@CrossOrigin(origins = "*")
@RestController
public class IntentProcessingController {
    private static final Logger logger = LoggerFactory.getLogger(IntentProcessingController.class);

    @PostMapping("/api/v1/webhook")
    public WebhookResponse receiveWebhook(@RequestBody WebhookRequest webhookRequest,
                               HttpServletRequest request,
                               HttpServletResponse response) {
        String requestId = request.getSession().getId();
        logger.info("[ " + requestId + " ] about to process request to return google map to dialogflow.");
        logger.info("[ " + requestId + " ] webhook request payload:\n " + webhookRequest);

        response.setStatus(200);

        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();

        FulfillmentMessageText text = new FulfillmentMessageText();
        text.setText(Collections.singletonList("Yo. Woho y3?"));

        fulfillmentMessage.setText(text);

        WebhookResponse webhookResponse = new WebhookResponse();
        webhookResponse.setFulfillmentMessages(Collections.singletonList(fulfillmentMessage));

        return webhookResponse;
    }
}
