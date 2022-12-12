package com.example.disasterresponsebotbackend.v1.domains.webhook.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WebhookRequest {

    private String responseId;

    private String session;

    private QueryResult queryResult;

    private Object originalDetectIntentRequest;
}
