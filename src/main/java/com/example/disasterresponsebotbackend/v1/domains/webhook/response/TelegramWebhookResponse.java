package com.example.disasterresponsebotbackend.v1.domains.webhook.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TelegramWebhookResponse {

    private String photo;

    private String caption;

    @JsonProperty("disable_notification")
    private boolean disableNotification;
}
