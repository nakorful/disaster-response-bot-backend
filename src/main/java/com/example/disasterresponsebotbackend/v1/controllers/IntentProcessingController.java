package com.example.disasterresponsebotbackend.v1.controllers;

import com.example.disasterresponsebotbackend.v1.domains.webhook.request.WebhookRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*")
@RestController
public class IntentProcessingController {
    private static final Logger logger = LoggerFactory.getLogger(IntentProcessingController.class);

    @PostMapping("/api/v1/webhook")
    public void receiveWebhook(@RequestBody WebhookRequest webhookRequest,
                               HttpServletRequest request,
                               HttpServletResponse response) {
        String requestId = request.getSession().getId();
        logger.info("[ " + requestId + " ] about to process request to return google map to dialogflow.");
        logger.info("[ " + requestId + " ] webhook request payload:\n " + webhookRequest);

        response.setStatus(200);
    }
}
