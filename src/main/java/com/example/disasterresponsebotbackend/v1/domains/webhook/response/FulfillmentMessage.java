package com.example.disasterresponsebotbackend.v1.domains.webhook.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FulfillmentMessage {

    private FulfillmentMessageText text;

    private TelegramWebhookResponse telegram;

    private Card card;
}
