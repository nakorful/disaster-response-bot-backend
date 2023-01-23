package com.example.disasterresponsebotbackend.v1.domains.webhook.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OriginalDetectIntentRequest {

    private String source;

    private OriginalDetectIntentRequestPayload payload;
}
