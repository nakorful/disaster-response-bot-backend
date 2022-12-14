package com.example.disasterresponsebotbackend.v1.controllers;

import com.example.disasterresponsebotbackend.v1.domains.webhook.request.WebhookRequest;
import com.example.disasterresponsebotbackend.v1.domains.webhook.response.*;
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


        String location = "New York, NY";

        // Set the size for the map image
        String size = "600x300";

        // Set the zoom level for the map
        int zoom = 12;

        // Construct the URL for the static map image
        String mapUrl = String.format("https://maps.googleapis.com/maps/api/staticmap?center=%s&size=%s&zoom=%s", location, size, zoom);

// Use the URL to generate the map image
//        let mapImage = `<img src="${mapUrl}" />`;

// Include the map image in the response
//        let response = `Here is a map of ${location}: ${mapImage}`;

        FulfillmentMessage fulfillmentMessage = new FulfillmentMessage();

        FulfillmentMessageText text = new FulfillmentMessageText();
//        text.setText(Collections.singletonList("https://www.google.com/maps/dir//5.7405146,-0.0093277/"));
//        text.setText(Collections.singletonList("<iframe width=\"600\" height=\"450\" style=\"border:0\" loading=\"lazy\" allowfullscreen src=\"https://www.google.com/maps/embed/v1/place?q=place_id:Eh5Uc2UgQWRkbyBIaWdoIFN0LCBBY2NyYSwgR2hhbmEiLiosChQKEgn51RwMN4XfDxE8_2KVKNnuiBIUChIJc6e3soSQ3w8R0y0OZdhO0b4&key=AIzaSyAiRVr85_YTnZPSo-FRMSNJlB4PUUYrSOs\"></iframe>"));

        Card card = new Card();
        card.setTitle("card title");
        card.setSubtitle("card text");
        card.setImageUri("https://images.pexels.com/photos/13716813/pexels-photo-13716813.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load");

        Button button = new Button();
        button.setText("button text");

        card.setButtons(Collections.singletonList(button));

//        fulfillmentMessage.setText(text);
        fulfillmentMessage.setCard(card);

        WebhookResponse webhookResponse = new WebhookResponse();
        webhookResponse.setFulfillmentMessages(Collections.singletonList(fulfillmentMessage));

        return webhookResponse;
    }
}
