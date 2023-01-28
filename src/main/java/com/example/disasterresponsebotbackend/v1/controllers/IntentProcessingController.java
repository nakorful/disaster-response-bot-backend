package com.example.disasterresponsebotbackend.v1.controllers;

import com.example.disasterresponsebotbackend.v1.domains.webhook.request.*;
import com.example.disasterresponsebotbackend.v1.domains.webhook.response.*;
import com.example.disasterresponsebotbackend.v1.domains.webhook.response.FulfillmentMessage;
import com.example.disasterresponsebotbackend.v1.domains.webhook.response.FulfillmentMessageText;
import com.example.disasterresponsebotbackend.v1.services.Utils;
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

        WebhookResponse webhookResponse = new WebhookResponse();

        if (webhookRequest != null) {
            String responseMessage = null;

            QueryResult queryResult = webhookRequest.getQueryResult();

            OriginalDetectIntentRequest originalDetectIntentRequest = webhookRequest.getOriginalDetectIntentRequest();
            OriginalDetectIntentRequestPayload payload = (originalDetectIntentRequest != null) ? originalDetectIntentRequest.getPayload() : null;
            OriginalDetectIntentRequestPayloadData data = (payload != null) ? payload.getData() : null;
            MessageSender from = (data != null) ? data.getFrom() : null;
            String firstName = (from != null) ? from.getFirstName() : null;

            logger.info("[ " + requestId + " ] message is being sent from " + firstName);

            if (queryResult != null) {
                Intent intent = queryResult.getIntent();

                if (intent != null) {
                    String intentDisplayName = intent.getDisplayName();

                    switch (intentDisplayName) {
                        case "enter-manager-id":
                            // get the message the admin sent. this message should be the manager id
                            String managerId = queryResult.getQueryText();
                            logger.info("[ " + requestId + " ] manager id passed by the admin is [ " + managerId + " ]");

                            // get available manager ids
                            String[] registeredManagerIds = Utils.getManagerIds();

                            logger.info("[ " + requestId + " ] about to check if entered manager id has been registered and it exists.");
                            boolean managerIdExists = false;

                            for (String id : registeredManagerIds) {
                                if (id.equalsIgnoreCase(managerId)) {
                                    managerIdExists = true;
                                    break;
                                }
                            }

                            if (managerIdExists) {
                                responseMessage = String.format("Manager %s, here are the reported outages over the last 10 days.", firstName);
                            } else {
                                // todo: send a response to the user and tell him that manager id he entered does not exist
                                responseMessage = "The id you entered does not exist.";
                            }
                    }
                }
            }

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
            text.setText(Collections.singletonList(responseMessage));
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
//        fulfillmentMessage.setCard(card);

            TelegramWebhookResponse telegram = new TelegramWebhookResponse();
            telegram.setText("Akoa y3 jon");
//        telegram.setPhoto("https://maps.googleapis.com/maps/api/staticmap?zoom=16&size=900x600&maptype=satellite&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318&markers=color:red%7Clabel:C%7C40.718217,-73.998284&key=AIzaSyAiRVr85_YTnZPSo-FRMSNJlB4PUUYrSOs&scale=2");
//        telegram.setCaption("This is a caption");
//        telegram.setDisableNotification(true);
//        webhookResponse.setFulfillmentMessages(Collections.singletonList(fulfillmentMessage));

//        fulfillmentMessage.setTelegram(telegram);
            fulfillmentMessage.setText(text);
            webhookResponse.setFulfillmentMessages(Collections.singletonList(fulfillmentMessage));
//            webhookResponse.setTelegram(telegram);

//        webhookResponse.setTelegram(telegram);
        }

        return webhookResponse;
    }

    private void nothing() {

    }
}
