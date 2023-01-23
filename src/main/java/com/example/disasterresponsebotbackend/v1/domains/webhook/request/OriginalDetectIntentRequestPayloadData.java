package com.example.disasterresponsebotbackend.v1.domains.webhook.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OriginalDetectIntentRequestPayloadData {

    private String text;

    private MessageSender from;

    private Long date;

    private ChatMessage chat;

    @JsonProperty("message_id")
    private String messageId;
}
