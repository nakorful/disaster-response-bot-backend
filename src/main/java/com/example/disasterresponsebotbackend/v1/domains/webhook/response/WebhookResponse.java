package com.example.disasterresponsebotbackend.v1.domains.webhook.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WebhookResponse {

    private List<FulfillmentMessage> fulfillmentMessages;
}
